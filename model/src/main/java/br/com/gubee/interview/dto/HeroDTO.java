package br.com.gubee.interview.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class HeroDTO {

    private UUID id;
    private String name;
    private String race;
    private boolean enabled;

    private Short strength;
    private Short agility;
    private Short dexterity;
    private Short intelligence;


}
