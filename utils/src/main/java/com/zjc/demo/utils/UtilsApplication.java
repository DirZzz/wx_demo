package com.zjc.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class UtilsApplication {

	public static void main(String[] args) {


		log.info("###############  Server Starting... ###############");
		ApplicationContext context = new SpringApplicationBuilder()
				.sources(UtilsApplication.class)
				.web(true)
				.run(args);

		log.info("###############  Server Starting End !!! ###############");

	}

}

