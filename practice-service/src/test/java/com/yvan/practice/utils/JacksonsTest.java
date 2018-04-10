package com.yvan.practice.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.dto.Data;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yvan on 2016/12/15.
 */
public class JacksonsTest {
    Logger logger = LoggerFactory.getLogger(CommonUtilsTest.class);

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void transforObject() throws Exception {
        Data data = new Data();
        Data object;
        data.setFullName("Hdal0er");
        data.setMobile("1#23456397863");
        String json = objectMapper.writeValueAsString(data);
        logger.info(json);
//        Data dataTemp = objectMapper.readValue(json, Data.class);
        JsonNode dataNode = objectMapper.readTree(json);
        object = (Data) Jacksons.transforObject(dataNode, Data.class);
        logger.info(objectMapper.writeValueAsString(object));
    }
}