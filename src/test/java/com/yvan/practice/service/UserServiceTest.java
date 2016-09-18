package com.yvan.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.PracticeYvanApplicationTests;
import com.yvan.practice.dto.Data;
import com.yvan.practice.entity.mysql.user.Gender;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.reponsetory.UserRepostory;
import com.yvan.practice.utils.CommonUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.Date;
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
        userService.findone(1L);
    }

    @Test
    public void delCacheUser() {
        userService.delCacheUser();
    }

    @Test
    public void serializeUser() throws Exception {
        User user;
        user = userService.findone(1L);
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
    public void jsonObjectConversion() throws IOException, InstantiationException, IllegalAccessException {
        Data data = new Data();
        Data object;
        data.setFullName("Hdal0er");
        data.setMobile("1#23456397863");
        String json = objectMapper.writeValueAsString(data);
        logger.info(json);
        JsonNode dataNode = objectMapper.readTree(json);
        object = (Data) CommonUtils.transforObject(dataNode, Data.class);
        logger.info(objectMapper.writeValueAsString(object));
    }




}