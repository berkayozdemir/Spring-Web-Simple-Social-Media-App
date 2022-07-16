package com.example.demo.controller;


import com.example.demo.model.PersonModel;
import com.example.demo.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    //returns view of signup page
    @RequestMapping("/signup")
    public ModelAndView signUpView() {
        ModelAndView modelAndView=new ModelAndView("signup.html");
        modelAndView.addObject("personModel",new PersonModel());



        return modelAndView;
    }

    //addObject and @Model Attribute process works same postcontroller
    @RequestMapping(value = "/signupPerson", method = RequestMethod.POST)
    public String signUpPerson(@ModelAttribute("personModel") PersonModel personModel)
    {
        signUpService.signUpPerson(personModel);


        return "redirect:login";
    }
}
