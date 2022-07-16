package com.example.demo.repository;

import com.example.demo.model.PostModel;
import com.example.demo.rowmapper.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


  public List<PostModel> getAll(){


        String sql="Select * from posttable order by sharedDate desc";
        return jdbcTemplate.query(sql,new PostRowMapper());

  }
    //query for a list of value according to a condition
    public List<PostModel> getAllById(int id){


        String sql="Select * from posttable where personId=?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,id);
            }
        }, new PostRowMapper());

    }



  public int savePost(PostModel postModel) {
        String sql="INSERT INTO posttable(username,content,subject,sharedDate,personId) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,postModel.getUsername(),postModel.getContent(),
                postModel.getSubject(),postModel.getSharedDate(),postModel.getPersonId());


  }

    //returns count of returned values according to a condition
    public int findPostCount(int id) {
        String sql="Select * from posttable where personId=?";
        List<PostModel> postModels= jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1,id);
            }
        },new PostRowMapper());

        System.out.println(postModels.size());
        return  postModels.size();
    }
}
