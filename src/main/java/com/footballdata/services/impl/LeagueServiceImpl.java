package com.footballdata.services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.footballdata.entities.LeagueEntity;
import com.footballdata.entities.LeagueRepository;
import com.footballdata.entities.PlayerEntity;
import com.footballdata.entities.PlayerRepository;
import com.footballdata.entities.TeamEntity;
import com.footballdata.entities.TeamRepository;
import com.footballdata.external.pojos.Competition;
import com.footballdata.external.pojos.Player;
import com.footballdata.external.pojos.PlayersInfo;
import com.footballdata.external.pojos.Team;
import com.footballdata.external.pojos.TeamsInfo;
import com.footballdata.services.LeagueService;

@Service("LeagueService")
public class LeagueServiceImpl implements LeagueService {

    private static final Logger LOGGER = Logger.getLogger(LeagueServiceImpl.class.getName());
    private static final String TEAMS = "teams";

    private volatile ConcurrentHashMap<String, Long> leagueIdsCache = new ConcurrentHashMap<>();
    private volatile Lock lock = new ReentrantLock();

    @Value("${app.user.agent}")
    private String userAgent;

    @Value("${app.url.base}")
    private String apiUrl;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public int getTotalPlayers(String leagueCode) {
        if (leagueIdsCache.isEmpty()) {
            initializeLeagueIdsCache();
        }
        Long leagueId = getLeagueId(leagueCode);
        if (leagueId == null) {
            throw new IllegalArgumentException();
        }
        List list = playerRepository.findByLeagueId(leagueId);
        return list.size();
    }

    private Long getLeagueId(String code) {
        Long leagueId;
        synchronized (leagueIdsCache) {
            leagueId = leagueIdsCache.get(code);
        }
        return leagueId;
    }

    @Override
    public boolean importLeagueInfo(String leagueCode) {
        if (leagueIdsCache.isEmpty()) {
            initializeLeagueIdsCache();
        }
        Long leagueId = getLeagueId(leagueCode);
        if (leagueId == null) {
            throw new IllegalArgumentException();
        }
        lock.lock();
        LeagueEntity league = leagueRepository.findByLeagueId(leagueId);
        if (league != null) {
            lock.unlock();
            return false;
        } else {
            saveLeagueInfo(leagueId);
            lock.unlock();
            saveTeamInfo(leagueId);
            return true;
        }
    }

    private void saveTeamInfo(Long leagueId) {
        TeamsInfo teamsInfo = (TeamsInfo) getResponseEntity(apiUrl + leagueId + "/" + TEAMS, TeamsInfo.class).getBody();
        for (int i = 0; i < teamsInfo.getTeams().length; i++) {
            Team team = teamsInfo.getTeams()[i];

            String[] teamUrl = team.getLinks().getSelf().getHref().split("/");
            Long teamId = Long.parseLong(teamUrl[teamUrl.length - 1]);

            TeamEntity teamEntity = new TeamEntity(teamId);
            teamEntity.setLeagueId(leagueId);
            teamEntity.setCode(team.getCode());
            teamEntity.setName(team.getName());
            teamEntity.setShortName(team.getShortName());

            teamRepository.save(teamEntity);
            savePlayerInfo(team.getLinks().getPlayers().getHref(), teamId, leagueId);
        }

    }

    private void savePlayerInfo(String apiUrl, Long teamId, Long leagueId) {
        PlayersInfo playersInfo = (PlayersInfo) getResponseEntity(apiUrl, PlayersInfo.class).getBody();
        for (int i = 0; i < playersInfo.getPlayers().length; i++) {
            Player player = playersInfo.getPlayers()[i];
            Integer jerseyNumber = player.getJerseyNumber();
            if (jerseyNumber == null) {
                // random number between 50 and 99
                jerseyNumber = new Integer((int)(Math.random() * 99 + 50));
            }
            PlayerEntity playerEntity = new PlayerEntity(teamId, jerseyNumber);
            if (player.getContractUntil() != null) {
                playerEntity.setContractUntil(LocalDate.from(DateTimeFormatter.ISO_DATE.parse(player.getContractUntil())));
            }
            if (player.getDateOfBirth() != null) {
                playerEntity.setDateOfBith(LocalDate.from(DateTimeFormatter.ISO_DATE.parse(player.getDateOfBirth())));
            }
            playerEntity.setName(player.getName());
            playerEntity.setNationality(player.getNationality());
            playerEntity.setPosition(player.getPosition());
            playerEntity.setLeagueId(leagueId);
            playerRepository.save(playerEntity);
        }
    }

    private void saveLeagueInfo(Long leagueId) {
        ResponseEntity<Competition> result = getResponseEntity(apiUrl + leagueId, Competition.class);
        Competition competition = result.getBody();
        LeagueEntity league = new LeagueEntity(leagueId);
        league.setCaption(competition.getCaption());
        league.setLeague(competition.getLeague());
        league.setYear(competition.getYear());
        leagueRepository.save(league);
    }


    private void initializeLeagueIdsCache() {
        synchronized (leagueIdsCache) {
            if (leagueIdsCache.isEmpty()) {
                try {
                    ResponseEntity<Competition[]> result = getResponseEntity(apiUrl, Competition[].class);
                    for (int i = 0; i < result.getBody().length; i++) {
                        Competition competition = result.getBody()[i];
                        leagueIdsCache.put(competition.getLeague(), new Long(competition.getId()));
                    }
                } catch (Exception e) {
                    LOGGER.log(Level.SEVERE, e.getMessage(), e);
                }
            }
        }
    }

    private ResponseEntity getResponseEntity(String apiUrl, Class responseClass) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add(HttpHeaders.USER_AGENT, userAgent);
        HttpEntity<?> entity = new HttpEntity(headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(apiUrl, HttpMethod.GET, entity, responseClass);
    }
}
