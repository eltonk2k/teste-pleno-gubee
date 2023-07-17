package br.com.gubee.interview.core.features.repository.imp;

import br.com.gubee.interview.dto.HeroDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class HeroDTOMapper implements RowMapper<HeroDTO> {
    @Override
    public HeroDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
        HeroDTO hero = new HeroDTO();

        hero.setName(rs.getString("name"));
        hero.setRace(rs.getString("race"));
        hero.setEnabled(rs.getBoolean("enabled"));
        hero.setStrength(rs.getShort("strength"));
        hero.setAgility(rs.getShort("agility"));
        hero.setDexterity(rs.getShort("dexterity"));
        hero.setIntelligence(rs.getShort("intelligence"));
        return hero;
    }
}