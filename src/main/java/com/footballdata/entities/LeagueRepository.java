package com.footballdata.entities;

import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<LeagueEntity, Long> {

    LeagueEntity findByLeagueId(Long leagueId);
}
