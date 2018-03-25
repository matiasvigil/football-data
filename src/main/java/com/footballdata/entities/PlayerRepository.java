package com.footballdata.entities;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<PlayerEntity, PlayerId> {

    List<PlayerEntity> findByLeagueId(Long leagueId);
}
