package com.spring.workshop.databaseSpringJdbc.dao;

import com.spring.workshop.databaseSpringJdbc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //customRawMapper
    class PersonRawMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            return person;
        }
    }

    public List<Person> findAll() {
        return jdbcTemplate
                .query("select * from person",
                        new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate
                .queryForObject("select * from person where id = ?",
                        new BeanPropertyRowMapper<>(Person.class), id);
    }

    public int deleteById(int id) {
        return jdbcTemplate
                .update("delete from person where id = ?", id);
    }

    public int insert(Person person) {
        return jdbcTemplate
                .update("INSERT INTO person(id, name, location, birth_date)" +
                        " values (?, ?, ?, ?)",
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate
                .update("update person set name = ?, location =  ?, birth_date = ? " +
                                " where id = ?",
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()),
                        person.getId());
    }

}
