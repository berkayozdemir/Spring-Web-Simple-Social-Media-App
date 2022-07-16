package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;



@Data
@Table(name="personrepo")
public class PersonModel {



    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;


    private String role;

    private String pw;
    private LocalDateTime signUpDate;




}
