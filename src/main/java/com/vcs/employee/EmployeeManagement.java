package com.vcs.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagement {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement.class, args);
		System.out.println("\n\nWelcome to the Employee Management System");
		System.out.println("\nHit localhost:<PORT> on your Web-Browser");
	}

}
