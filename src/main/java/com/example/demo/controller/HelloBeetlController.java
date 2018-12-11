package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HelloBeetlController {

    @RequestMapping(value={"/beetl/add"},method= RequestMethod.GET)
    public ModelAndView testBeetl(){

        ModelAndView modelAndView = new ModelAndView();
        System.out.println("add request");
        modelAndView.addObject("email", "apk2sf@163.com");
        modelAndView.setViewName("index1");

        return modelAndView;
    }

}

