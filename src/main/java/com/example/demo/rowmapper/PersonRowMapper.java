package com.example.demo.rowmapper;

import com.example.demo.model.PersonModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonRowMapper implements RowMapper<PersonModel> {
    @Override
    public PersonModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        PersonModel personModel=new PersonModel();
        personModel.setId(rs.getInt("id"));
        personModel.setUsername(rs.getString("username"));
        personModel.setPw(rs.getString("pw"));
        personModel.setRole(rs.getString("role"));
        personModel.setSignUpDate(rs.getTimestamp("signUpDate").toLocalDateTime());
        return personModel;

    }
}
