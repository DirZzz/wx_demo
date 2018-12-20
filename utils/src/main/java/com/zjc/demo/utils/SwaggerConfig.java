package com.zjc.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sandu
 * @ClassName SwaggerConfig
 * @date 2018/11/6
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig   {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zjc.demo.utils.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}
