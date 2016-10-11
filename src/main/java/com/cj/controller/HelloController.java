package com.cj.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cj.po.User;

@Controller
public class HelloController {
    private Logger logger = Logger.getLogger(HelloController.class);
    
    /*
    *   http://localhost:8080/hello?name=cn.7player
     */
    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        logger.info("hello");
        model.addAttribute("name", name);
        return "hello";
    }
    
    @RequestMapping("/hello2")
    public String greeting2(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        logger.info("hello2");
        User user = new User();
        user.setName(name);
        model.addAttribute("user", user);
        return "simple/hello2";
    }
}
