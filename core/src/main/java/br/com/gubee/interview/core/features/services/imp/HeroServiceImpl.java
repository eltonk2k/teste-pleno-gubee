package br.com.gubee.interview.core.features.services.imp;

import br.com.gubee.interview.core.features.repository.imp.HeroRepositoryImpl;
import br.com.gubee.interview.core.features.repository.imp.PowerStatsRepositoryImpl;
import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import br.com.gubee.interview.dto.PowerStatsDTO;
import br.com.gubee.interview.model.PowerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HeroServiceImpl implements HeroService {



    @Autowired
    private HeroRepositoryImpl heroRepository;

    @Autowired
    private PowerStatsRepositoryImpl powerStatsRepository;



    @Override
    public HeroDTO findById(UUID id) {
        return heroRepository.findById(id);
    }

    @Override
    public HeroDTO findByName(String name) {
        return heroRepository.findByName(name);
    }

    @Override
    public HeroDTO save(HeroDTO heroDTO) {

        PowerStatsDTO powerStatsDTO = new PowerStatsDTO();
        PowerStats powerStats = new PowerStats();
        powerStats.setStrength(powerStatsDTO.getStrength());
        powerStats.setAgility(powerStatsDTO.getAgility());
        powerStats.setDexterity(powerStatsDTO.getDexterity());
        powerStats.setIntelligence(powerStatsDTO.getIntelligence());
        powerStatsRepository.save(powerStatsDTO);
        return heroDTO;
    }

    @Override
    public HeroDTO update(UUID id, HeroDTO heroDTO) {
//        HeroDTO existingHero = heroRepository.findById(id);
//        if (existingHero != null) {
//            Hero updatedHero = convertToEntity(heroDTO);
//            updatedHero.setId(existingHero.getId());
//            return convertToDTO(updatedHero);
//        }
//        return null;
        HeroDTO existingHero = heroRepository.findById(id);
        if (existingHero != null) {
            heroRepository.update(id, heroDTO);
            UUID uuid = heroRepository.findPowerStatsById(id);
            powerStatsRepository.update(uuid, heroDTO);

        }

        return existingHero;
    }

    @Override
    public void deleteById(UUID id) {
        heroRepository.deleteById(id);

    }

//    private HeroDTO convertToDTO(Hero hero) {
//        HeroDTO heroDTO = new HeroDTO();
//        heroDTO.setId(hero.getId());
//        heroDTO.setName(hero.getName());
//        heroDTO.setRace(hero.getRace());
//        return heroDTO;
//    }
//
//    private Hero convertToEntity(HeroDTO heroDTO) {
//        Hero hero = new Hero();
//        hero.setId(heroDTO.getId());
//        hero.setName(heroDTO.getName());
//        hero.setRace(heroDTO.getRace());
//        hero.setEnabled(heroDTO.isEnabled());
//        return hero;
//    }
}
