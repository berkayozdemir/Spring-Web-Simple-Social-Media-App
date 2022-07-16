package com.example.demo.service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SignUpService {

    private final PersonRepository personRepository;

    @Autowired
    public SignUpService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //adding user role,signup date and sends to the repository
    public void signUpPerson(PersonModel personModel) {
        personModel.setSignUpDate(LocalDateTime.now());
        personModel.setRole("ROLE_USER");
        System.out.println(personModel);
        personRepository.savePerson(personModel);


    }


}
