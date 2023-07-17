package br.com.gubee.interview.core.features.services.imp;

import br.com.gubee.interview.core.features.repository.HeroRepository;
import br.com.gubee.interview.core.features.repository.imp.HeroRepositoryImpl;
import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HeroServiceImpl implements HeroService {



    @Autowired
    private HeroRepositoryImpl heroRepository;


    @Override
    public HeroDTO findById(UUID id) {

        return null;
    }

    @Override
    public HeroDTO findByName(String name) {
        return null;
    }

    @Override
    public HeroDTO save(HeroDTO heroDTO) {
        return null;
    }

    @Override
    public HeroDTO update(UUID id, HeroDTO heroDTO) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
