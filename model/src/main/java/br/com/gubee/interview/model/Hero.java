package br.com.gubee.interview.model;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;



@NoArgsConstructor
@Getter
@Setter
public class Hero implements Serializable {


    private UUID id;
    private String name;
    private String race;
    private Boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private PowerStats powerStats;


}
