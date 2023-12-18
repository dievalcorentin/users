package com.graphmytech.administrationusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.graphmytech.AdministrationUsers", "com.graphmytech.AdministrationUsers.Controller", "com.graphmytech.AdministrationUsers.Repository"})
public class AdministrationUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrationUsersApplication.class, args);
	}

}
