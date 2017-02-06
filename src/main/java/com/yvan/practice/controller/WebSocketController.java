package com.yvan.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yvan on 2017/2/5.
 */
@RestController
public class WebSocketController {

//    @GetMapping(value = "/chatRoom")
//    public String getIn() {
//        return "websocket/index";
//    }

    @GetMapping(value = "/chatRoom")
    public ModelAndView form() {
        return new ModelAndView("websocket/index");
    }
}
