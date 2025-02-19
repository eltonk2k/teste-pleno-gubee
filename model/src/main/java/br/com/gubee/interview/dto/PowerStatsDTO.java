package br.com.gubee.interview.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class PowerStatsDTO {


    private Short strength;
    private Short agility;
    private Short dexterity;
    private Short intelligence;
}
