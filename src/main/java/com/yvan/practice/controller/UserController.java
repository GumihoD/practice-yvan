package com.yvan.practice.controller;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> feature/first
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yvan on 16/7/20.
 */
@RestController
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

<<<<<<< HEAD
    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;


}

=======
//    public

}
>>>>>>> feature/first
