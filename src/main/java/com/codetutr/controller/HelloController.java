package com.codetutr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(Model model){
        model.addAttribute("msg", "Hello");
        return "home";
    }

}
