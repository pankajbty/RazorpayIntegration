package com.in28minutes.springboot.basics.sprintbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SprintbootIn10StepsApplication {

	public static void main(String[] args) {
//		ApplicationContext applicationContext = SpringApplication.run(SprintbootIn10StepsApplication.class, args);
		SpringApplication.run(SprintbootIn10StepsApplication.class, args);
		
//		for(String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
	}

	@Bean
	public LocaleResolver localeResolver() {
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

}
