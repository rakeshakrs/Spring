package com.rakeshpoc.schoolapp.repository;

import com.rakeshpoc.schoolapp.model.Holiday;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidaysRepository {

    private final JdbcTemplate jdbcTemplate;

    public HolidaysRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Holiday> displayHolidays(){
        String sql="Select * from Holidays";
        var rowMapper=BeanPropertyRowMapper.newInstance(Holiday.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
