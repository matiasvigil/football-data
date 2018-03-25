package com.footballdata.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "league")
public class LeagueEntity {

    @Id
    private Long leagueId;
    private String caption;
    private String league;
    private Integer year;

    public LeagueEntity() {}
    public LeagueEntity(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
