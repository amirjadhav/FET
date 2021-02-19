package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	// url parameter strategy
	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
        .favorParameter(true)
        .parameterName("mediatype")
        .ignoreAcceptHeader(true)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("json", MediaType.APPLICATION_JSON);
    }
}
