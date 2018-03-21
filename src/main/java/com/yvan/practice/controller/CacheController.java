package com.yvan.practice.controller;

import com.wordnik.swagger.annotations.Api;
import com.yvan.practice.dto.ControllerResult;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yvan on 2016/12/7.
 */
@RestController
@RequestMapping("cache")
@Api(value = "cache")
public class CacheController {

    @Autowired
    UserService userService;

    @RequestMapping("clearCacheUser")
    public void clearUser() {
        userService.delCacheUser();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ControllerResult getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        modelAndView.addObject(user);
        return ControllerResult.defaultSuccessResult(modelAndView);
    }
}
