package com.yvan.practice.h2test;

import com.yvan.practice.PracticeYvanApplicationTests;
import com.yvan.practice.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by yvan on 16/8/22.
 */
@ActiveProfiles("h2test") // 需要和H2模拟的数据源对应上
public class H2test extends PracticeYvanApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void findUser() {
        Assert.assertNotNull(userService.findone(1L));
    }
}
