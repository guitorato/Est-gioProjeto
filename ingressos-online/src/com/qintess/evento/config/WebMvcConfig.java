package com.qintess.evento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.qintess.evento.controller",
								"com.qintess.evento.dao"})
public class WebMvcConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/paginas/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
		.addResourceHandler("/qintess/**")
		.addResourceLocations("/qintess/");
		
	}
}
