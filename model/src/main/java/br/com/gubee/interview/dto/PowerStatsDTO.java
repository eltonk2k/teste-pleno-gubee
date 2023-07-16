package br.com.gubee.interview.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;


public class PowerStatsDTO {


    private UUID id;
    private Short strength;
    private Short agility;
    private Short dexterity;
    private Short intelligence;
}
