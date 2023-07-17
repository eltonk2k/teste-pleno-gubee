package br.com.gubee.interview.core.features.hero;


import br.com.gubee.interview.core.features.services.HeroService;
import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/heros")
public class HeroController {

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HeroDTO> findById(@PathVariable UUID id) {
        HeroDTO heroDTO = heroService.findById(id);
        return ResponseEntity.ok(heroDTO);
    }

    @PostMapping
    public ResponseEntity<HeroDTO> created(@RequestBody HeroDTO heroDTO) {
        HeroDTO herosave = heroService.save(heroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(herosave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeroDTO> update(@PathVariable UUID id, @RequestBody HeroDTO heroDTO) {
        HeroDTO heroUpdate = heroService.update(id, heroDTO);
        return ResponseEntity.ok(heroUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        heroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
