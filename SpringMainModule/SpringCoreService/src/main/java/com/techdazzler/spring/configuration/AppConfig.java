package com.techdazzler.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.techdazzler.spring.service.EmployeeService;
import com.techdazzler.spring.service.EmployeeServiceImpl;


@Configuration
@ComponentScan({"com.techdazzler.spring","com.techdazzler.hibernate","primefaces.spring.web.mbeans"})
public class AppConfig {

	@Bean
	public EmployeeService employeeService(){
		return new EmployeeServiceImpl();
	}
	
}
