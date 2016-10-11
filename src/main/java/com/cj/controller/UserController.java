package com.cj.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cj.po.User;
import com.cj.service.UserService;
import com.github.pagehelper.Page;

@Controller
public class UserController {
 
    private Logger logger = Logger.getLogger(UserController.class);
 
    @Autowired
    private UserService userService;
 
    /*
     *  http://localhost:8080/getUserInfo
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public List<User> getUserInfo() {
        List<User> userInfo = userService.getUserInfo();
        if(userInfo!=null && !userInfo.isEmpty()){
        	logger.info("ListUser Size"+userInfo.size());
        }
        return userInfo;
    }
    
    @RequestMapping("/getUserInfoById")
    @ResponseBody
    public User getUserInfoById(@RequestParam(value="id", required=true) Long id) {
    	User user = userService.getUserInfoById(id);
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }
    
    @RequestMapping("/getUserInfoByPage")
    @ResponseBody
    public Page getUserInfoByPage() {
    	Page page = userService.getUserInfoByPage();
        return page;
    }
}