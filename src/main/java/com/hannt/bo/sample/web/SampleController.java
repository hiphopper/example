package com.hannt.bo.sample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleController {
    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping
    public String sampleForm(){
        return "sample";
    }
}
