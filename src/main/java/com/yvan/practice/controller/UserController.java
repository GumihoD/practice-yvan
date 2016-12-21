package com.yvan.practice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.dto.ControllerResult;
import com.yvan.practice.dto.Data;
import com.yvan.practice.service.MessageService;
import com.yvan.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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