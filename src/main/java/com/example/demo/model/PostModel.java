package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;





@Data
@Table(name = "posttable")
public class PostModel {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;


    private String username;
    private  String subject;
    private String content;
    private LocalDateTime sharedDate;
    private int personId;




}
