package com.footballdata.external.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "_links",
        "count",
        "teams"
})
public class TeamsInfo {

    @JsonProperty("_links")
    private Links links;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("teams")
    private Team[] teams;

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

    @JsonProperty("teams")
    public Team[] getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "self",
            "competition"
    })
    public class Links {

        @JsonProperty("self")
        private Link self;
        @JsonProperty("competition")
        private Link competition;

        @JsonProperty("self")
        public Link getSelf() {
            return self;
        }

        @JsonProperty("self")
        public void setSelf(Link self) {
            this.self = self;
        }

        @JsonProperty("competition")
        public Link getCompetition() {
            return competition;
        }

        @JsonProperty("competition")
        public void setCompetition(Link competition) {
            this.competition = competition;
        }

    }
}
