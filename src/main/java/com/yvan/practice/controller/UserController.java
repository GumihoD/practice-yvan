package com.yvan.practice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.dto.Data;
import com.yvan.practice.dto.Result;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.service.UserService;
import com.yvan.practice.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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


    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result user(@PathVariable("id") Long id) {
        logger.info("test user GET");
        User user = userService.findone(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        modelAndView.addObject(user);
//        Locale
        List list = new ArrayList();
        return Result.commonResult(user);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public Data jsonObjectConversion() throws IOException, InstantiationException, IllegalAccessException {
        Data data = new Data();
        Data object;
        data.setFullName("Hdal0er");
        data.setMobile("1#23456397863");
        String json = objectMapper.writeValueAsString(data);
        logger.info(json);
//        Data dataTemp = objectMapper.readValue(json, Data.class);
        JsonNode dataNode = objectMapper.readTree(json);
        object = (Data) CommonUtils.transforObject(dataNode, Data.class);
        logger.info(objectMapper.writeValueAsString(object));
        return object;
    }
}

