package com.yvan.practice;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServletComponentScan
@EnableScheduling
@EnableJpaAuditing
@EnableCaching
@EnableTransactionManagement
@ComponentScan("${server.basePackages}")
@SpringBootApplication
public class PracticeYvanApplication extends SpringBootServletInitializer {


    @Value("${jackson.indent.output}")
    private boolean jacksonIndentOutput = false;

    /**
     * 用户缓存的有效时间
     */
    @Value("${currentUser.Expire}")
    private Long currentUserExpire;

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        if (this.jacksonIndentOutput) {
            //缩排输出
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }

        //设置null转换
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer() {
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                jgen.writeString("");
            }
        });
        Hibernate4Module hibernateMoudle = new Hibernate4Module();
        hibernateMoudle.disable(Hibernate4Module.Feature.USE_TRANSIENT_ANNOTATION);
        return objectMapper.registerModule(new JodaModule()).registerModule(hibernateMoudle);
    }


    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".html");
        return internalResourceViewResolver;
    }


    //Jackson2ObjectMapperBuilder
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE");
//            }
//        };
//    }
//    /**
//     * 方法二：使用代码注册Servlet（不需要@ServletComponentScan注解）
//     *
//     * @return
//     * @author SHANHY
//     * @create  2016年1月6日
//     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new MyServlet(), "/xs/*");// ServletName默认值为首字母小写，即myServlet
//    }



    /**
     * redisTemplate redis模板工具类
     * 须添加连接工厂
     *
     * @param factory
     * @returns
     */
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    /**
     * 缓存管理
     * 绑定redis 设置指定缓存的存活时间
     *
     * @param factory
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        RedisCacheManager cacheManager = new RedisCacheManager(template);
        Map expires = new HashMap();
        expires.put("userCache", currentUserExpire * 3600);
        cacheManager.setExpires(expires);
        return cacheManager;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PracticeYvanApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PracticeYvanApplication.class, args);
    }
}
