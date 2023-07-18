package br.com.gubee.interview.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PowerStats {

    private UUID id;
    private Short strength;
    private Short agility;
    private Short dexterity;
    private Short intelligence;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
