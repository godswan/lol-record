package com.lol.config;

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
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/"),regex("/summoner.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swany API").description("Swany API Reference for Developers")
				.termsOfServiceUrl("https://Swany.github.io").contact("Swany@naver.com").license("Swany License")
				.licenseUrl("Swany@naver.com").version("1.0").build();
	}

}