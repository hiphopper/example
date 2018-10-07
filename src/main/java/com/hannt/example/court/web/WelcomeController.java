package com.hannt.example.court.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping
    public String welcome(Model model){
        Date today = new Date();
        model.addAttribute("today", today);
        return "welcome";
    }
}
