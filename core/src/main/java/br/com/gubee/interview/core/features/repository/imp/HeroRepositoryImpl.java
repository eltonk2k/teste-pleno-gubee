package br.com.gubee.interview.core.features.repository.imp;

import br.com.gubee.interview.core.features.repository.HeroRepository;
import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public class HeroRepositoryImpl implements HeroRepository {


    private final JdbcTemplate jdbcTemplate;

//https://www.twilio.com/blog/java-custom-queries-jdbctemplate-springboot
//https://www.digitalocean.com/community/tutorials/spring-jdbctemplate-example

    @Autowired
    public HeroRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public HeroDTO findById(UUID id) {
        return jdbcTemplate.queryForObject("SELECT h.name, h.race, h.enabled, p.strength, p.agility, p.dexterity, p.intelligence " +
                "FROM hero h INNER JOIN power_stats p ON h.power_stats_id = p.id WHERE h.id = ?", new HeroDTOMapper(), id);
    }

    @Override
    public HeroDTO findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT h.name, h.race, h.enabled, p.strength, p.agility, p.dexterity, p.intelligence " +
                "FROM hero h INNER JOIN power_stats p ON h.power_stats_id = p.id WHERE h.name = ?", new HeroDTOMapper(), name);
    }

    @Override
    public UUID findPowerStatsById(UUID id) {
        return jdbcTemplate.queryForObject("SELECT h.power_stats_id " +
                "FROM hero h INNER JOIN power_stats p ON h.power_stats_id = p.id WHERE h.id = ?", new HeroDTOMapper(), id).getId();
    }

    @Override
    public int save(HeroDTO hero, UUID PowerStatsId) {
        return jdbcTemplate.update("INSERT INTO interview_service.hero (id, name, race, power_stats_id) " +
                        "VALUES (interview_service.uuid_generate_v4(), ?, ?, ?)", hero.getName(), hero.getRace(), PowerStatsId);
    }

    @Override
    public int update(UUID id, HeroDTO hero) {
        return jdbcTemplate.update("UPDATE interview_service.hero SET name = ?, race = ?, enabled = ?, updated_at = now() " +
                "WHERE id = ?", hero.getName(), hero.getRace(), hero.isEnabled(), id);
    }

    @Override
    public int deleteById(UUID id) {
        return jdbcTemplate.update("DELETE FROM interview_service.hero WHERE id = ?", id);
    }


}



