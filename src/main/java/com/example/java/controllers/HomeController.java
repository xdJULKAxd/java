package com.example.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

//    @RequestMapping("/")
//    @ResponseBody
//    public String index() {
//        return "Hello World!";
//    }

    @RequestMapping("/template")
    public String template() {
        return "template";
    }

    @RequestMapping("/auto")
    public String auto() {
        return "auto";
    }

    @RequestMapping("/tree")
    public String tree() {
        return "tree";
    }

}

