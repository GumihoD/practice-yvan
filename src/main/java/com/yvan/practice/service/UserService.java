package com.yvan.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.reponsetory.UserRepostory;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.xml.ws.WebServiceException;
import java.io.IOException;

/**
 * Created by yvan on 16/8/2.
 */
@Component
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserRepostory userRepostory;

    @Cacheable(cacheNames = "userCache", key = "'currentUser'")
    public User getUser(Long id) {
        try {
            for (int i = 0; i < 10; i++) {
                userRepostory.findOne(id);
            }
            logger.info(objectMapper.writeValueAsString(userRepostory.findOne(id)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return userRepostory.findOne(id);
    }

    @CacheEvict(cacheNames = "userCache", key = "'currentUser'")
    public void delCacheUser() {

    }

    public void serializeUser(User user) {
        try {
            redisTemplate.opsForValue().set(String.format("currentUser", String.valueOf(user.getId())), objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public User getUserFromRedis(Long id) {
        try {
            User user = new User();
            BeanUtils.copyProperties(user,
                    objectMapper.readTree((String) redisTemplate.opsForValue().get(String.format("currentUser", String.valueOf(id)))));
            return user;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }


}
