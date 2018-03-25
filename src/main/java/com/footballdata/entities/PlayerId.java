package com.footballdata.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PlayerId implements Serializable {

    private static final long serialVersionUID = -1761275768125313464L;
    @NotNull
    private Long teamId;
    @NotNull
    private Integer jerseyNumber;

    public PlayerId() {
    }

    public PlayerId(Long teamId, Integer jerseyNumber) {
        this.teamId = teamId;
        this.jerseyNumber = jerseyNumber;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerId)) return false;
        PlayerId that = (PlayerId) o;
        return Objects.equals(teamId, that.teamId) &&
                Objects.equals(jerseyNumber, that.jerseyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, jerseyNumber);
    }
}
