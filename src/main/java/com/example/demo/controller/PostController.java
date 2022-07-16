package com.example.demo.controller;

import com.example.demo.model.PostModel;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //return view of post.html
    //we are adding a postmodel object so can capture the model for his logic
    @RequestMapping("/postPage")
    public ModelAndView postContent()

    {
        ModelAndView modelAndView=new ModelAndView("post.html");
        modelAndView.addObject("postmodel",new PostModel());
        return modelAndView;

    }

    //asks  'postmodel' attribute as a postmodel from view, after its setting inputs from post.html and performs and saves postmodel to database after submit button clicked
    @RequestMapping(value = "/savePost",method = POST)
    public String savePost( @ModelAttribute("postmodel")  PostModel postModel, Errors errors) {

        //sending object to service class
        postService.addPost(postModel);


        return "redirect:homepage";


    }



}
