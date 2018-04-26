package com.yvan.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.PracticeYvanApplicationTests;
import com.yvan.practice.entity.mysql.user.Gender;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.repository.UserRepostory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yvan on 16/8/4.
 */
public class UserServiceTest extends PracticeYvanApplicationTests {

    Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserRepostory userRepostory;

    @Test
    public void getUserById() throws Exception {
        userService.getUser(1L);
    }

    @Test
    public void delCacheUser() {
        userService.delCacheUser();
    }

    @Test
    public void serializeUser() throws Exception {
        User user;
        user = userService.getUser(1L);
        userService.serializeUser(user);
    }

    @Test
    public void getUser() throws Exception {
        logger.info(objectMapper.writeValueAsString(userService.getUserFromRedis(1L)));
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("yvan");
        user.setBirthday(new Date());
        user.setEmail("123@123.com");
        user.setGender(Gender.female);
        user.setPassword("123123");
        userRepostory.save(user);
    }

    @Test
    public void getUsers() throws JsonProcessingException {
        List<User> users = userRepostory.findAll();
        for (User user : users) {
            logger.info(objectMapper.writeValueAsString(user));
        }
    }

    @Test
    public void findByUserNameOrEmail() {
        User user = new User();
        user.setUsername("");
        user.setEmail("yvan");
        List<User> users = userService.findByUserNameOrEmail(user);
        System.out.println("=========================================");
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User userTemp = iterator.next();
            System.out.println(userTemp.getUsername());
            System.out.println(userTemp.getEmail());
        }
    }

}