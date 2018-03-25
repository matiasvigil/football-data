package com.footballdata.external.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_links",
        "id",
        "caption",
        "league",
        "year",
        "currentMatchday",
        "numberOfMatchdays",
        "numberOfTeams",
        "numberOfGames",
        "lastUpdated"
})
public class Competition {

    @JsonProperty("_links")
    private Links links;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("league")
    private String league;
    @JsonProperty("year")
    private Integer year;
    @JsonProperty("currentMatchday")
    private Integer currentMatchday;
    @JsonProperty("numberOfMatchdays")
    private Integer numberOfMatchdays;
    @JsonProperty("numberOfTeams")
    private Integer numberOfTeams;
    @JsonProperty("numberOfGames")
    private Integer numberOfGames;
    @JsonProperty("lastUpdated")
    private String lastUpdated;


    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("caption")
    public String getCaption() {
        return caption;
    }

    @JsonProperty("caption")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @JsonProperty("league")
    public String getLeague() {
        return league;
    }

    @JsonProperty("league")
    public void setLeague(String league) {
        this.league = league;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("currentMatchday")
    public Integer getCurrentMatchday() {
        return currentMatchday;
    }

    @JsonProperty("currentMatchday")
    public void setCurrentMatchday(Integer currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    @JsonProperty("numberOfMatchdays")
    public Integer getNumberOfMatchdays() {
        return numberOfMatchdays;
    }

    @JsonProperty("numberOfMatchdays")
    public void setNumberOfMatchdays(Integer numberOfMatchdays) {
        this.numberOfMatchdays = numberOfMatchdays;
    }

    @JsonProperty("numberOfTeams")
    public Integer getNumberOfTeams() {
        return numberOfTeams;
    }

    @JsonProperty("numberOfTeams")
    public void setNumberOfTeams(Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    @JsonProperty("numberOfGames")
    public Integer getNumberOfGames() {
        return numberOfGames;
    }

    @JsonProperty("numberOfGames")
    public void setNumberOfGames(Integer numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "self",
            "teams",
            "fixtures",
            "leagueTable"
    })
    public class Links {

        @JsonProperty("self")
        private Link self;
        @JsonProperty("teams")
        private Link teams;
        @JsonProperty("fixtures")
        private Link fixtures;
        @JsonProperty("leagueTable")
        private Link leagueTable;

        @JsonProperty("self")
        public Link getSelf() {
            return self;
        }

        @JsonProperty("self")
        public void setSelf(Link self) {
            this.self = self;
        }

        @JsonProperty("teams")
        public Link getTeams() {
            return teams;
        }

        @JsonProperty("teams")
        public void setTeams(Link teams) {
            this.teams = teams;
        }

        @JsonProperty("fixtures")
        public Link getFixtures() {
            return fixtures;
        }

        @JsonProperty("fixtures")
        public void setFixtures(Link fixtures) {
            this.fixtures = fixtures;
        }

        @JsonProperty("leagueTable")
        public Link getLeagueTable() {
            return leagueTable;
        }

        @JsonProperty("leagueTable")
        public void setLeagueTable(Link leagueTable) {
            this.leagueTable = leagueTable;
        }
    }
}

