package com.footballdata.services;

public interface LeagueService {

    int getTotalPlayers(String leagueCode);

    boolean importLeagueInfo(String leagueCode);
}
