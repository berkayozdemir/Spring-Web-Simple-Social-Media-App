package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//object for body of response entity. look at to the rest package for more understanding
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String statuscode;
    private String statusMessage;
}
