package com.yvan.practice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置
 * 项目启动之后 访问：http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.yvan.practice"))
                .paths(PathSelectors.any())
                .build();
    }

    private springfox.documentation.service.ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("基于spring-boot的web服务")
                .description("此项目以swagger图形化界面直观展示接口演示，包含多样的功能及工具类方法。")
//                .title("practice-yvan")
//                .description("Spring Boot中使用Swagger2构建RESTful APIs")
                .version("1.0")
                .build();

    }
}