package com.yvan.practice.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * jackson utils
 * Created by Jeffrey on 15/11/5.
 */
public class Jacksons {

    private ObjectMapper mapper;

    public static Jacksons getInstance() {
        return new Jacksons();
    }

    private Jacksons() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer() {
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString("");
            }
        });
        Hibernate4Module module = new Hibernate4Module();
        module.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        mapper.registerModule(new JodaModule()).registerModule(module);
    }

    public Jacksons filter(String filterName, SimpleBeanPropertyFilter propertyFilter) {
        FilterProvider provider = new SimpleFilterProvider().addFilter(filterName, propertyFilter);
        mapper.setFilterProvider(provider);
        annotationIntrospector();
        return this;
    }

    public Jacksons filterProvider(FilterProvider provider) {
        mapper.setFilterProvider(provider);
        annotationIntrospector();
        return this;
    }

    public <T> T json2Obj(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析json错误");
        }
    }

    public String writeAsString(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析对象错误");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> json2List(String json) {
        try {
            return mapper.readValue(json, List.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析json错误");
        }
    }

    private void annotationIntrospector() {
        mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            @Override
            public Object findFilterId(Annotated a) {
                Object id = super.findFilterId(a);
                return generateFilter(a, id);
            }
        });
    }

    public static void setAnnotationIntrospector(ObjectMapper objectMapper) {
        objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {
            @Override
            public Object findFilterId(Annotated a) {
                Object id = super.findFilterId(a);
                return generateFilter(a, id);
            }
        });
    }

    private static Object generateFilter(Annotated a, Object id) {
        if (null != id) {
            return id;
        }
        String filterName = a.getName();
        if (filterName.contains("java.util.")) {
            return null;
        }
        return !filterName.contains(".") ? null : filterName;
    }

    /**
     * 自定义jsonNode 转对象方法
     *
     * @param jsonNode
     * @param z
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object transforObject(JsonNode jsonNode, Class<?> z) throws IllegalAccessException, InstantiationException {
        Object obj = z.newInstance();
        Field[] declaredFields = z.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            declaredField.set(obj, jsonNode.get(declaredField.getName()).asText());
        }
        return obj;
    }
}
