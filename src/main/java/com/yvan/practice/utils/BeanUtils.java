package com.yvan.practice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.entity.mysql.user.User;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yvan on 2016/11/14.
 */
public class BeanUtils extends org.springframework.beans.BeanUtils {

    /**
     * 获取为null的属性名
     * 在copyproperty的时候忽略这些属性是
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void main(String[] args) throws JsonProcessingException {
        User source = new User();
        source.setUsername("test");
        source.setPassword("6666666");
        User target = new User();
        target.setUsername("1");
        target.setPassword("2");
        target.setBirthday(new Date());
        target.setEmail(".....");
        BeanUtils.copyProperties(source,target,getNullPropertyNames(source));
        System.out.println(new ObjectMapper().writeValueAsString(target));
    }
}
