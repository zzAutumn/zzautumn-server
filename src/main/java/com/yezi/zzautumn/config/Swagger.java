package com.yezi.zzautumn.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author
 */
@Configuration
@EnableSwagger2
public class Swagger {


    @Bean
    public Docket createRestApi() {


        return new Docket(DocumentationType.SWAGGER_2).groupName("zzautumn server").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.yezi.zzautumn.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * @return
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title("zzautumn server").description("The server side API for zzautum")
                .termsOfServiceUrl("*").version("1.0").contact(new Contact("zzautumn", "", "")).build();
    }

}
