package com.footballdata.external.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class PlayersInfo {

    @JsonProperty("_links")
    private Links links;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("players")
    private Player[] players;

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    @JsonProperty("players")
    public Player[] getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(Player[] players) {
        this.players = players;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "self",
            "team"
    })
    public class Links {

        @JsonProperty("self")
        private Link self;
        @JsonProperty("team")
        private Link team;

        @JsonProperty("self")
        public Link getSelf() {
            return self;
        }

        @JsonProperty("self")
        public void setSelf(Link self) {
            this.self = self;
        }

        @JsonProperty("team")
        public Link getTeam() {
            return team;
        }

        @JsonProperty("team")
        public void setTeam(Link team) {
            this.team = team;
        }

    }
}
