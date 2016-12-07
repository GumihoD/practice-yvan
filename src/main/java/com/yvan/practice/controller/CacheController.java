package com.yvan.practice.controller;

import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

/**
 * Created by yvan on 2016/12/7.
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired
    UserService userService;

    @RequestMapping("user")
    public User getUser(@QueryParam("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("clearCacheUser")
    public void clearUser() {
        userService.delCacheUser();
    }
}
