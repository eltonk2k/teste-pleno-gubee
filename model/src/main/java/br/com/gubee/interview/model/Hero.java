package br.com.gubee.interview.model;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


public class Hero implements Serializable {


    private UUID id;
    private String name;
    private String race;
    private Boolean enabled = true;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private PowerStats powerStats;


}
