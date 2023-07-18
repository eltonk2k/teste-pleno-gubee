package br.com.gubee.interview.core.features.hero;

import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.core.features.services.imp.HeroServiceImpl;
import br.com.gubee.interview.dto.HeroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class HeroControllerTest {

    private MockMvc mockMvc;

    @Mock
    private HeroServiceImpl heroService;

    @InjectMocks
    private HeroController heroController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(heroController).build();
    }

    @Test
    public void testFindById() throws Exception {
        UUID id = UUID.randomUUID();
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(id);
        heroDTO.setName("Superman");
        heroDTO.setRace("Kryptonian");

        when(heroService.findById(eq(id))).thenReturn(heroDTO);

        mockMvc.perform(get("/heros/{id}", id.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Superman"))
                .andExpect(jsonPath("$.race").value("Kryptonian"));

        verify(heroService, times(1)).findById(eq(id));
    }

    @Test
    public void testFindByName() throws Exception {
        String name = "Superman";
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setId(UUID.randomUUID());
        heroDTO.setName(name);
        heroDTO.setRace("ALIEN");

        when(heroService.findByName(eq(name))).thenReturn(heroDTO);

        mockMvc.perform(get("/heros/heroName/{name}", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Superman"));

        verify(heroService, times(1)).findByName(eq(name));
    }

    @Test
    public void testCreated() throws Exception {
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Superman");
        heroDTO.setRace("Kryptonian");

        HeroDTO savedHero = new HeroDTO();
        savedHero.setId(UUID.randomUUID());
        savedHero.setName("Superman");
        savedHero.setRace("Kryptonian");

        when(heroService.save(any(HeroDTO.class))).thenReturn(savedHero);

        mockMvc.perform(post("/heros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(heroDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(savedHero.getId().toString()))
                .andExpect(jsonPath("$.name").value("Superman"))
                .andExpect(jsonPath("$.race").value("Kryptonian"));

        verify(heroService, times(1)).save(any(HeroDTO.class));
    }

    @Test
    public void testUpdate() throws Exception {
        UUID id = UUID.randomUUID();
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Superman");
        heroDTO.setRace("Kryptonian");

        HeroDTO updatedHero = new HeroDTO();
        updatedHero.setId(id);
        updatedHero.setName("Superman");
        updatedHero.setRace("Human");

        when(heroService.update(eq(id), any(HeroDTO.class))).thenReturn(updatedHero);

        mockMvc.perform(put("/heros/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(heroDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.name").value("Superman"))
                .andExpect(jsonPath("$.race").value("Human"));

        verify(heroService, times(1)).update(eq(id), any(HeroDTO.class));
    }

    @Test
    public void testUpdateHeroNotFound() throws Exception {
        UUID id = UUID.randomUUID();
        HeroDTO heroDTO = new HeroDTO();
        heroDTO.setName("Superman");
        heroDTO.setRace("Kryptonian");

        when(heroService.update(eq(id), any(HeroDTO.class))).thenReturn(null);

        mockMvc.perform(put("/heros/{id}", id.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(heroDTO)))
                .andExpect(status().isNotFound());

        verify(heroService, times(1)).update(eq(id), any(HeroDTO.class));
    }

    @Test
    public void testDelete() throws Exception {
        UUID id = UUID.randomUUID();

        mockMvc.perform(delete("/heros/{id}", id.toString()))
                .andExpect(status().isNoContent());

        verify(heroService, times(1)).deleteById(eq(id));
    }

    // Método auxiliar para converter objeto para JSON
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
