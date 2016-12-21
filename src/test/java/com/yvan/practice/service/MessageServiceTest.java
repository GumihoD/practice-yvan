package com.yvan.practice.service;

import com.yvan.practice.PracticeYvanApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yvan on 2016/12/20.
 */
public class MessageServiceTest extends PracticeYvanApplicationTests {

    @Autowired
    MessageService messageService;

    @Test
    public void sendMsg() throws Exception {
        messageService.sendMsg("{\"mobile\":\"15601894368\",\"temp_id\":1}\n");
    }

}