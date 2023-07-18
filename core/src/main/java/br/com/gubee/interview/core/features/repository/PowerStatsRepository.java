package br.com.gubee.interview.core.features.repository;

import br.com.gubee.interview.dto.HeroDTO;
import br.com.gubee.interview.dto.PowerStatsDTO;

import java.util.UUID;

public interface PowerStatsRepository {


    UUID findById(UUID id);

    int save(PowerStatsDTO powerStatsDTO);

    int update(UUID id, HeroDTO heroDTO);

    int deleteById(UUID id);
}
