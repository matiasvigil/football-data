package com.footballdata.entities;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class PlayerEntity {

    @EmbeddedId
    private PlayerId playerId;
    private Long leagueId;
    private String name;
    private String position;
    private LocalDate dateOfBith;
    private String nationality;
    private LocalDate contractUntil;

    public PlayerEntity(){}

    public PlayerEntity(Long teamId, Integer jerseyNumber) {
        this.playerId = new PlayerId(teamId, jerseyNumber);
    }

    public Long getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }

    public Long getTeamId() {
        return playerId.getTeamId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getJerseyNumber() {
        return playerId.getJerseyNumber();
    }

    public LocalDate getDateOfBith() {
        return dateOfBith;
    }

    public void setDateOfBith(LocalDate dateOfBith) {
        this.dateOfBith = dateOfBith;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(LocalDate contractUntil) {
        this.contractUntil = contractUntil;
    }
}
