/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren.config;

import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Global;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            //加了ApiOperation注解的类，才生成接口文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            //包下的类，才生成接口文档
            //.apis(RequestHandlerSelectors.basePackage("io.renren.controller"))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(security());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("人人开源")
            .description("renren-fast文档")
            .termsOfServiceUrl("https://www.renren.io")
            .version("3.0.0")
            .build();
    }

    private List<ApiKey> security() {
        return newArrayList(
            new ApiKey("token", "token", "header")
        );
    }
//
//    // 验证
//    private List<ApiKey> securitySchemes() {
//        List<ApiKey> apiKeyList = new ArrayList();
//        apiKeyList.add(new ApiKey("token", "token", "header"));
//        return apiKeyList;
//    }
//
//    private List<SecurityContext> securityContexts() {
//        List<SecurityContext> securityContexts = new ArrayList<>();
//        securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth())
//                .forPaths(PathSelectors.regex("^(?!auth).*$"))//过滤要验证的路径
//                .build());
//        return securityContexts;
//    }
//
//    //增加全局认证
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        List<SecurityReference> securityReferences = new ArrayList<>();
//        securityReferences.add(new SecurityReference("token", authorizationScopes));//验证增加（有许多教程说明中这个地方是Authorization,导致不能带入全局token，因为securitySchemes()方法中header写入token，所以这个地方我改为token就可以了）
//        return securityReferences;
//    }
//
//    /**
//     * 添加摘要信息
//     */
//    private ApiInfo apiInfo() {
//        // 用ApiInfoBuilder进行定制
//        return new ApiInfoBuilder()
//                .title("接口文档")
//                //.description("用于说明接口使用")
//                //.contact(new Contact("minhope", null, null))
////                .version("版本号:" + Global.getSwaggerDescribeVersion())
//                .build();
//    }
}