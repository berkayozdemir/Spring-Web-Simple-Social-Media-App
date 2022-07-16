package com.example.demo.controller;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PostService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class HomeController {



    private final PersonRepository personRepository;
    private final PostService postService;


    @Autowired
    public HomeController(PersonRepository personRepository, PostService postService) {
        this.personRepository = personRepository;
        this.postService = postService;
    }


    //getting view of homepage.html after login and adding current user to session
    @GetMapping("/homepage")
    public ModelAndView homePageView(Authentication authentication, HttpSession httpSession) {

        PersonModel personModel=personRepository.findPersonFromUsername(authentication.getName());
        httpSession.setAttribute("currentPerson",personModel);


        ModelAndView modelAndView=new ModelAndView("homepage.html");
        int count=postService.findPostCountFromCurrentUser();
        modelAndView.addObject("postcount",count);
        modelAndView.addObject("username",personModel.getUsername());
        modelAndView.addObject("allPosts",postService.getAllPosts());
        return modelAndView;
    }
}
