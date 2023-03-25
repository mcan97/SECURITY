package com.course.securitydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.course.securitydemo.Constant;

@Controller
public class HomeController{

    @GetMapping(path = {"", "/", "/home"})
    public String index(){
        return "index";
    }
    
    
    @GetMapping(path = {"/admin"})
    public String adminPage() {
    	return "adminPage";
    }
    
    @GetMapping(path = {"/user"})
    public String userPage() {
    	return "userPage";
    }

}