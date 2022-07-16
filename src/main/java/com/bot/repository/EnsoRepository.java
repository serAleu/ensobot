package com.bot.repository;

import com.bot.repository.dto.RainbowEnso;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
@RequiredArgsConstructor
public class EnsoRepository {

    @Autowired
    final JdbcTemplate jdbcTemplate;

    public RainbowEnso getRainbowEnsoByScenarioId(Long scenarioId){
        try {
            return jdbcTemplate.queryForObject("select SCENARIO_ID, SCENARIO_NAME " +
                    "from rainbow_enso " +
                    "where scenario_id = ? ",
                    (rs, rowNum) -> new RainbowEnso()
                            .setScenarioId(rs.getLong("SCENARIO_ID"))
                            .setScenarioName(rs.getString("SCENARIO_NAME")),
            scenarioId);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
