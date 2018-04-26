package com.yvan.practice.repository;

import com.yvan.practice.entity.mysql.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yvan on 16/8/2.
 */
public interface UserRepostory extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
