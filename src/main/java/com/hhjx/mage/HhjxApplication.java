package com.hhjx.mage;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@ComponentScan(basePackages={"com.hhjx.mage"})
@SpringBootApplication
@EnableTransactionManagement 
public class HhjxApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhjxApplication.class, args);
	}

}
