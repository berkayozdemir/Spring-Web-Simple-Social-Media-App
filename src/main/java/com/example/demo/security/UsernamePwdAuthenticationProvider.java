package com.example.demo.security;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class UsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    //checks user credentials and login or not
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        //information of current user
        String username=authentication.getName();
        String password=authentication.getCredentials().toString();

        //looks for an existing person from database according to username
        PersonModel personModel=personRepository.findPersonFromUsername(username);

        //comparing username and password which given and finded from database informations
        if(personModel!=null && personModel.getId()>=0 && personModel.getPw().equals(password))
         {
             return new UsernamePasswordAuthenticationToken(username,password, Collections.singleton(new GrantedAuthority() {
                 @Override
                 public String getAuthority() {
                     return personModel.getRole();
                 }
             }));
         }

        else {
            throw  new  BadCredentialsException("Invalid!");
        }




    }

    //compulsory overrided support class
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
