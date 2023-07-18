package br.com.gubee.interview.core.features.hero;

import br.com.gubee.interview.core.features.repository.imp.HeroRepositoryImpl;
import br.com.gubee.interview.core.features.repository.imp.PowerStatsRepositoryImpl;
import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.core.features.services.imp.HeroServiceImpl;
import br.com.gubee.interview.dto.PowerStatsDTO;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;
import br.com.gubee.interview.dto.HeroDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ActiveProfiles("it")
public class HeroServiceIT {

    @InjectMocks
    private HeroServiceImpl heroService;

    @Mock
    private HeroRepositoryImpl heroRepository;

    @Mock
    private PowerStatsRepositoryImpl powerStatsRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindById() {
        UUID id = UUID.randomUUID();
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(id);
        heroDTO.setName("Superman");
        heroDTO.setRace("Kryptonian");
        when(heroService.findById(id)).thenReturn(heroDTO);
        Assertions.assertNotNull(heroDTO);
        Assertions.assertEquals(id, heroDTO.getId());
    }

    @Test
    public void testFindByName() {
        String name = "Superman";
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(UUID.randomUUID());
        heroDTO.setName(name);
        heroDTO.setRace("ALIEN");

        when(heroService.findByName(name)).thenReturn(heroDTO);
        Assertions.assertNotNull(heroDTO);
        Assertions.assertEquals(name, heroDTO.getName());
    }

    @Test
    @DisplayName("Teste salvar incompleto")
    public void testSave() {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Spider-Man");
        heroDTO.setRace("Human");
        PowerStatsDTO powerStatsDTO = new PowerStatsDTO();
        powerStatsDTO.setStrength((short) 10);
        powerStatsDTO.setAgility((short) 8);
        powerStatsDTO.setDexterity((short) 7);
        powerStatsDTO.setIntelligence((short) 9);


        HeroDTO savedHero = heroService.save(heroDTO);
        //when(heroService.save(heroDTO)).thenReturn(heroDTO);
        Assertions.assertNotNull(savedHero);
        Assertions.assertNotNull(savedHero.getId());
        Assertions.assertEquals(heroDTO.getName(), savedHero.getName());
        Assertions.assertEquals(heroDTO.getRace(), savedHero.getRace());

        // Verifica se o heroi foi salvo no banco
        HeroDTO retrievedHero = heroRepository.findById(savedHero.getId());
        Assertions.assertNotNull(retrievedHero);
        Assertions.assertEquals(savedHero.getId(), retrievedHero.getId());
        Assertions.assertEquals(savedHero.getName(), retrievedHero.getName());
        Assertions.assertEquals(savedHero.getRace(), retrievedHero.getRace());

//        UUID powerStatsId = heroRepository.findPowerStatsById(savedHero.getId());
//        PowerStatsDTO retrievedPowerStats = powerStatsRepository.findById(powerStatsId);
//        Assertions.assertNotNull(retrievedPowerStats);
//        Assertions.assertEquals(powerStatsDTO.getStrength(), retrievedPowerStats.getStrength());
//        Assertions.assertEquals(powerStatsDTO.getAgility(), retrievedPowerStats.getAgility());
//        Assertions.assertEquals(powerStatsDTO.getDexterity(), retrievedPowerStats.getDexterity());
//        Assertions.assertEquals(powerStatsDTO.getIntelligence(), retrievedPowerStats.getIntelligence());
    }

    @Test
    public void testUpdate() {
        UUID id = UUID.randomUUID();
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Iron Man");
        heroDTO.setRace("Human");

        //HeroDTO updatedHero = heroService.update(id, heroDTO);
        when(heroService.update(id, heroDTO)).thenReturn(heroDTO);
        Assertions.assertNotNull(heroDTO);
        Assertions.assertEquals(heroDTO.getName(), heroDTO.getName());
        Assertions.assertEquals(heroDTO.getRace(), heroDTO.getRace());

        // Verifica se o heroi foi atualizado no banco
        HeroDTO retrievedHero = heroRepository.findById(id);
        Assertions.assertNotNull(retrievedHero);
        Assertions.assertEquals(heroDTO.getName(), retrievedHero.getName());
        Assertions.assertEquals(heroDTO.getRace(), retrievedHero.getRace());
    }

    @Test
    public void testDeleteById() {
        UUID id = UUID.randomUUID();
        heroService.deleteById(id);

        // Verifica se o heroi foi deletado do banco
        HeroDTO deletedHero = heroRepository.findById(id);
        Assertions.assertNull(deletedHero);
    }

}
