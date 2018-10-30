package com.example.demo.controller;

import com.example.demo.base.ApiResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODD
 * @Author Administrator
 * @Date 2018/10/29 0029 下午 4:42
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser")
    public String  getUser(Model model){
        System.out.println(userService.getUser());
        return "index";
    }

    @RequestMapping(value = "/getApiStatus")
    @ResponseBody
    public ApiResponse getApiStatus(){
        return ApiResponse.ofMessage();
    }

    @RequestMapping(value = "/get")
    public String get(){
        return "index";
    }
}
