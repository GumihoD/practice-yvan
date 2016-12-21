package com.yvan.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.dto.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/**
 * Created by yvan on 2016/12/20.
 */
@Component
public class MessageService {

    Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    ObjectMapper objectMapper;

    private static final String url = "https://api.sms.jpush.cn/v1/codes";

    @Autowired
    RestTemplate restTemplate;

    public String sendMsg(Data params) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        MediaType mediaType = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(mediaType);
        headers.add("Authorization", "Basic ZWI4NzYxYjVmZWY4ZDA1NzU4MjRlZTNiOmQxNTViYmZkNDdlMWI2NDU2ZmI0Y2NlNQ==");
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> formEntity = new HttpEntity<>(objectMapper.writeValueAsString(params), headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        logger.info(result);
        return result;
    }
}
