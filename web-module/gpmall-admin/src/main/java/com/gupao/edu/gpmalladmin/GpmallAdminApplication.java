package com.gupao.edu.gpmalladmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:spring/application-commons.xml"})
public class GpmallAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpmallAdminApplication.class, args);
	}
}
