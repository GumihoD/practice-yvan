package com.yvan.practice.test.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by yvan on 2017/2/9.
 * Spring 中使用servlet filter listner
 *
 * @WebFilter、@WebListener 类似配合@ServletComponentScan注解使用
 */
@WebServlet(urlPatterns = {"/testServlet/*"}, description = "testServlet")
public class TestServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            /** 反射 获取私有方法 1 setAccessible 2 getDeclaredMethod  */
            Class[] args = {HttpServletRequest.class, HttpServletResponse.class};
            Method method = this.getClass().getDeclaredMethod("doGet", args);
            method.setAccessible(true);
            logger.info(this.getClass().getName() + "." + method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class[] args = {HttpServletRequest.class, HttpServletResponse.class};
            Method method = this.getClass().getDeclaredMethod("doPost", args);
            method.setAccessible(true);
            logger.info(this.getClass().getName() + "." + method.getName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
