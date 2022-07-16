package com.example.demo.rowmapper;

import com.example.demo.model.PostModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<PostModel> {
    @Override
    public PostModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        PostModel postModel=new PostModel();
        postModel.setPostId(rs.getInt("id"));
        postModel.setUsername(rs.getString("username"));
        postModel.setContent(rs.getString("content"));
        postModel.setSubject(rs.getString("subject"));
        postModel.setSharedDate(rs.getTimestamp("sharedDate").toLocalDateTime());
        postModel.setPersonId(rs.getInt("personId"));





        return postModel;
    }
}
