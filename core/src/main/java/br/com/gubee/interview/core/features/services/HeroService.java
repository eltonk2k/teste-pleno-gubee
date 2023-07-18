package br.com.gubee.interview.core.features.services;

import br.com.gubee.interview.dto.HeroDTO;

import java.util.UUID;

public interface HeroService {

    HeroDTO findById(UUID id);

    HeroDTO findByName(String name);

    HeroDTO save(HeroDTO heroDTO);

    HeroDTO update(UUID id, HeroDTO heroDTO);

    void deleteById(UUID id);

}
