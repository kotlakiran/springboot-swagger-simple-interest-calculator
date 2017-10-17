package com.kiran.spring.swagger.simpleinterestcalculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/test.*"), regex("/api/*.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Simple Interest Calculator REST API")
				.description("Simple Interest Calculator REST API reference for developers")
				.termsOfServiceUrl("https://github.com/kirankotla")
				.contact("kiran.kotla90@gmail.com").license("kiran kotla")
				.licenseUrl("kiran.kotla90@gmail.comm").version("1.0").build();
	}

}