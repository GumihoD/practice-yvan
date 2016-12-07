package com.yvan.practice.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yvan.practice.entity.mysql.user.User;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by yvan on 2016/11/14.
 */
public class BeanUtils extends BeanUtilsBean {
    private final Log log = LogFactory.getLog(BeanUtils.class);

    /**
     * 获取为null的属性名
     * 在copyProperties时候忽略这些属性是
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


    /**
     * 复制
     *
     * @param dest
     * @param orig
     * @param ignoreNullFlag
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void copyProperties(Object dest, Object orig, boolean ignoreNullFlag) throws IllegalAccessException, InvocationTargetException {
        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        } else if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        } else {
            if (this.log.isDebugEnabled()) {
                this.log.debug("BeanUtils.copyProperties(" + dest + ", " + orig + "," + ignoreNullFlag + ")");
            }

            int i;
            String name;
            Object e;
            if (orig instanceof DynaBean) {
                DynaProperty[] origDescriptors = ((DynaBean) orig).getDynaClass().getDynaProperties();

                for (i = 0; i < origDescriptors.length; ++i) {
                    name = origDescriptors[i].getName();
                    if (this.getPropertyUtils().isReadable(orig, name) && this.getPropertyUtils().isWriteable(dest, name)) {
                        e = ((DynaBean) orig).get(name);
                        if (ignoreNullFlag) {
                            if (e != null) this.copyProperty(dest, name, e);
                        } else {
                            this.copyProperty(dest, name, e);
                        }
                    }
                }
            } else if (orig instanceof Map) {
                Map var8 = (Map) orig;
                Iterator var10 = var8.entrySet().iterator();

                while (var10.hasNext()) {
                    Map.Entry var11 = (Map.Entry) var10.next();
                    String var12 = (String) var11.getKey();
                    if (this.getPropertyUtils().isWriteable(dest, var12)) {
                        if (ignoreNullFlag) {
                            if (var11.getValue() != null) this.copyProperty(dest, var12, var11.getValue());
                        } else {
                            this.copyProperty(dest, var12, var11.getValue());
                        }
                    }
                }
            } else {
                PropertyDescriptor[] var9 = this.getPropertyUtils().getPropertyDescriptors(orig);

                for (i = 0; i < var9.length; ++i) {
                    name = var9[i].getName();
                    if (!"class".equals(name) && this.getPropertyUtils().isReadable(orig, name) && this.getPropertyUtils().isWriteable(dest, name)) {
                        try {
                            e = this.getPropertyUtils().getSimpleProperty(orig, name);
                            if (ignoreNullFlag) {
                                if (e != null) this.copyProperty(dest, name, e);
                            } else {
                                this.copyProperty(dest, name, e);
                            }
                        } catch (NoSuchMethodException var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            }

        }
    }

//    public static void main(String[] args) throws JsonProcessingException {
//        User source = new User();
//        source.setUsername("test");
//        source.setPassword("6666666");
//        User target = new User();
//        target.setUsername("1");
//        target.setPassword("2");
//        target.setBirthday(new Date());
//        target.setEmail(".....");
////        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
//        System.out.println(new ObjectMapper().writeValueAsString(target));
//    }
}
