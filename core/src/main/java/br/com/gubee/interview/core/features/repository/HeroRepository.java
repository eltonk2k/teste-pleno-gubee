package br.com.gubee.interview.core.features.repository;


import br.com.gubee.interview.dto.HeroDTO;

import java.util.UUID;



public interface HeroRepository {


    HeroDTO findById(UUID id);

    HeroDTO findByName(String name);

    UUID findPowerStatsById(UUID id);

    int save(HeroDTO heroDTO, UUID PowerStatsId);

    int update(UUID id, HeroDTO heroDTO);

    int deleteById(UUID id);
}
