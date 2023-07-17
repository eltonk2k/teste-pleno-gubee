package br.com.gubee.interview.core.features.repository.imp;


import br.com.gubee.interview.core.features.repository.PowerStatsRepository;
import br.com.gubee.interview.dto.HeroDTO;
import br.com.gubee.interview.dto.PowerStatsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PowerStatsImpl implements PowerStatsRepository {


    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public PowerStatsImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int save(PowerStatsDTO powerStatsDTO) {
        return jdbcTemplate.update("INSERT INTO interview_service.power_stats (strength, agility, dexterity, intelligence) " +
                        "VALUES (interview_service.uuid_generate_v4(), ?, ?, ?, ?)", powerStatsDTO.getStrength(), powerStatsDTO.getAgility(), powerStatsDTO.getDexterity(),
                powerStatsDTO.getIntelligence());
    }

    @Override
    public int update(UUID id, HeroDTO heroDTO) {
        return jdbcTemplate.update("UPDATE interview_service.power_stats SET strength = ?, agility = ?, dexterity = ?, intelligence = ? " +
                        "WHERE id = ?", heroDTO.getStrength(), heroDTO.getAgility(), heroDTO.getDexterity(),
                heroDTO.getIntelligence(), id);
    }

    @Override
    public int deleteById(UUID id) {
        return jdbcTemplate.update("DELETE FROM interview_service.power_stats WHERE id = ?", id);

    }

}
