package com.example.demo.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

//return login view for get or post method type
@RequestMapping(value = {"login","/",""},method = { RequestMethod.GET, RequestMethod.POST })
public String loginPage(Model model) {

    return "login.html";
}




//perform logout and logic. more about  SecurityContextHolder: https://javarevisited.blogspot.com/2018/02/what-is-securitycontext-and-SecurityContextHolder-Spring-security.html#axzz7ZE0POCTZ
@RequestMapping(value = {"/performLogout"},method = {RequestMethod.POST ,RequestMethod.GET,})
public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     new SecurityContextLogoutHandler().logout(request,response,auth);

        return "redirect:login";
    }






}
