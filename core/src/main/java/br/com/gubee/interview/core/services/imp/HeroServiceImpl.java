package br.com.gubee.interview.core.services.imp;

import br.com.gubee.interview.core.repository.HeroRepository;
import br.com.gubee.interview.core.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HeroServiceImpl implements HeroService {



    @Autowired
    private HeroRepository heroRepository;


    @Override
    public HeroDTO findById(UUID id) {
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
    public void delete(UUID id) {

    }
}
