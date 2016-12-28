package com.yvan.practice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.dto.ControllerResult;
import com.yvan.practice.dto.Data;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.service.MessageService;
import com.yvan.practice.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.WebApplicationException;

/**
 * Created by yvan on 16/7/20.
 */
@RestController
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MessageService messageService;


    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResult login(@RequestBody User user) {
        if (user == null || "".equals(user.getUsername()))
            throw new WebApplicationException("用户名不能为空");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return ControllerResult.defaultNullSuccessResult("Login Success!");
    }


    @RequestMapping(value = "sendMsg", method = RequestMethod.POST)
    @ResponseBody
    public ControllerResult getUser(@RequestBody Data msg) {
        try {
            return ControllerResult.defaultSuccessResult(messageService.sendMsg(msg));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ControllerResult.defaultFailResult("...GG");
    }


}