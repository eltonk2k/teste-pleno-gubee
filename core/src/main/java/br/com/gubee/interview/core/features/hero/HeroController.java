package br.com.gubee.interview.core.features.hero;


import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/heros")
public class HeroController {

    @Autowired
    private HeroService heroService;



    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> findById(@PathVariable UUID id) {
        HeroDTO heroDTO = heroService.findById(id);
        return ResponseEntity.ok(heroDTO);
    }

    @GetMapping("/heroName/{name}")
    public ResponseEntity<HeroDTO> findByName(@PathVariable String name) {
        HeroDTO heroDTO = heroService.findByName(name);
        return ResponseEntity.ok(heroDTO);
    }

    @PostMapping
    public ResponseEntity<HeroDTO> created(@RequestBody HeroDTO heroDTO) {
        HeroDTO herosave = heroService.save(heroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(herosave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroDTO> update(@PathVariable UUID id, @RequestBody HeroDTO heroDTO) {
        HeroDTO updatedHero = heroService.update(id, heroDTO);
        if (updatedHero != null) {
            return ResponseEntity.ok(updatedHero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        heroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
