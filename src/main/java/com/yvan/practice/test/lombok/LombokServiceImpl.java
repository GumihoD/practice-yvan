package com.yvan.practice.test.lombok;

import lombok.extern.slf4j.Slf4j;

/**
 * @Slf4j 声明日志
 */
@Slf4j
public class LombokServiceImpl {

    public void logAction(){
        LombokEntity lombokEntity = new LombokEntity();
        lombokEntity.setId(1);
        lombokEntity.setName("name");
        log.info("lombokEntity:{}", lombokEntity);
        log.info("log.info");
        log.debug("log.debug");
        log.error("log.error");
    }
}
