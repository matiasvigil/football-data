package com.footballdata.external.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_links",
        "name",
        "code",
        "shortName",
        "squadMarketValue",
        "crestUrl"
})
public class Team {

    @JsonProperty("_links")
    private Links links;
    @JsonProperty("name")
    private String name;
    @JsonProperty("code")
    private String code;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("squadMarketValue")
    private Object squadMarketValue;
    @JsonProperty("crestUrl")
    private String crestUrl;

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("shortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("shortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("squadMarketValue")
    public Object getSquadMarketValue() {
        return squadMarketValue;
    }

    @JsonProperty("squadMarketValue")
    public void setSquadMarketValue(Object squadMarketValue) {
        this.squadMarketValue = squadMarketValue;
    }

    @JsonProperty("crestUrl")
    public String getCrestUrl() {
        return crestUrl;
    }

    @JsonProperty("crestUrl")
    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "self",
            "fixtures",
            "players"
    })
    public class Links {

        @JsonProperty("self")
        private Link self;
        @JsonProperty("fixtures")
        private Link fixtures;
        @JsonProperty("players")
        private Link players;

        @JsonProperty("self")
        public Link getSelf() {
            return self;
        }

        @JsonProperty("self")
        public void setSelf(Link self) {
            this.self = self;
        }

        @JsonProperty("fixtures")
        public Link getFixtures() {
            return fixtures;
        }

        @JsonProperty("fixtures")
        public void setFixtures(Link fixtures) {
            this.fixtures = fixtures;
        }

        @JsonProperty("players")
        public Link getPlayers() {
            return players;
        }

        @JsonProperty("players")
        public void setPlayers(Link players) {
            this.players = players;
        }
    }
}
