package com.surveybuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class ClientRespondentMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRespondentMsApplication.class, args);
	}


	@Bean
	public Docket surveyAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.surveybuilder"))
				.build();
	}


    @Configuration
    class RestTemplateConfig {
            
            @Bean
            //@LoadBalanced
            public RestTemplate restTemplate() {
              return new RestTemplate();
            }
    }

}
