package com.yvan.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.entity.mysql.user.User;
import com.yvan.practice.repository.UserRepostory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by yvan on 16/8/2.
 */
@Component
public class UserService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserRepostory userRepostory;

    /**
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "userCache", key = "'practice:currentUser:Id:'+#p0")
//    @Cacheable(cacheNames = "userCache")
    public User getUser(Long id) {
        User user = userRepostory.findOne(id);
        try {
            logger.info(objectMapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return user;
    }

    @CacheEvict(cacheNames = "userCache", allEntries = true)
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

    public User findByUserName(String userName) {
        return userRepostory.findByUsername(userName);
    }

    public List<User> findByUserNameOrEmail(User user) {
        String username = user == null ? "%%" : null == user.getUsername() ? "%%" : "%" + user.getUsername() + "%";
        String email = user == null ? "%%" : null == user.getEmail() ? "%%" : "%" + user.getEmail() + "%";
        System.out.println("=============="+username + user);
        StringBuffer sql = new StringBuffer();
        sql.append(" select username,password,email,birthday,gender ");
        sql.append(" from user a where a.username like ? and email like ? ");
//        List<User> users = jdbcTemplate.queryForList(sql.toString(), new Object[]{username, email}, User.class);
        List<User> users = jdbcTemplate.query(sql.toString(), new Object[]{username, email}, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

}
