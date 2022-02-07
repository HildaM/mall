package com.quan.mall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName: Swagger2Config
 * @Description: Swagger 配置类
 * @author: Hilda   Hilda_quan@163.com
 * @date: 2022/2/7 10:40
 */

@Configuration
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为当前包下的controller生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.quan.mall.controller"))
                // 为有@Api注解的Controller生成文档
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        //为有@ApiOperation注解的方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SwaggerUI 演示")
                .description("mall-quan")
                .contact(new Contact("quan", "quan.com", "Hilda_quan@163.com"))
                .version("0.2")
                .build();
    }
}
