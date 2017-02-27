package com.example;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.example")
public class DemoSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}
	
	public Docket newsApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("produits")
				.apiInfo(ApiInfo())
				.select()
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build();
	}

	private ApiInfo ApiInfo() {
		return new ApiInfoBuilder()
				.title("Spring boot Sample with Swagger")
				.description("We use Mr Mouhamed Youssfi About Spring boot and "
						+ "angular to build json file that we can use to put our"
						+ " service in Bluemix")
				.contact("Dhafer Dhib")
				.license("Apache License Version 2.0")
				.licenseUrl("___")
				.version("1.0")
				.build();
	}
}
