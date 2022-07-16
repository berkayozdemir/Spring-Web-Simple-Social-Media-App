package com.example.demo.repository;

import com.example.demo.model.PersonModel;
import com.example.demo.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //logic for getting only one value
    public PersonModel findPersonFromId(int personId) {
        String sql="Select * from personrepo where id=?";
        PersonModel personModel=(PersonModel) jdbcTemplate.queryForObject(sql,new Object[] {personId},new PersonRowMapper());

        return personModel;


    }

    //logic for adding value inside
    public void savePerson(PersonModel personModel) {
        String sql="insert into personrepo(username,pw,signUpDate,role) values(?,?,?,?)";
        jdbcTemplate.update(sql,personModel.getUsername(),personModel.getPw(),personModel.getSignUpDate(),personModel.getRole());


    }




    public PersonModel findPersonFromUsername(String username) {
        String sql="Select * from personrepo where username=?";

        PersonModel personModel=(PersonModel) jdbcTemplate.queryForObject(sql,new Object[] {username},new PersonRowMapper());

        return personModel;

    }



}
