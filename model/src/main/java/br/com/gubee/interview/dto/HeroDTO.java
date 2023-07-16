package br.com.gubee.interview.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class HeroDTO {

    private UUID id;
    private String name;
    private String race;
    private boolean enabled = true;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
