package com.yvan.practice.test.lombok;

import org.junit.Test;

public class LombokServiceImplTest {
    private static LombokServiceImpl lombokService;

    static {
        lombokService = new LombokServiceImpl();
    }
    @Test
    public void logAction() {
        //Lombok toString lombokEntity:LombokEntity(id=1, name=name)
        //JSON_STYLE lombokEntity:{"id":1,"name":"name"}
        lombokService.logAction();
    }
}