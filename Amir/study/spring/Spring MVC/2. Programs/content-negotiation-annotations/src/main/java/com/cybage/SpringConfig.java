package com.cybage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@EnableWebMvc
@ComponentScan(basePackages = "com.cybage")
@Configuration
public class SpringConfig implements  WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	//using URL Parameter Strategy --> http://localhost:8087/spring-mvc/employee/101?mediaType=xml
	//	@Override
	//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	//		configurer.favorPathExtension(false).
	//		favorParameter(true).
	//		parameterName("mediaType").
	//		ignoreAcceptHeader(true).
	//		defaultContentType(MediaType.APPLICATION_JSON).
	//		mediaType("xml", MediaType.APPLICATION_XML).
	//		mediaType("json", MediaType.APPLICATION_JSON);
	//	}

	//using URL Suffix Strategy -->http://localhost:8087/spring-mvc/employee/101.xml 
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
		favorParameter(false).
		ignoreAcceptHeader(true).
		defaultContentType(MediaType.APPLICATION_JSON).
		mediaType("xml", MediaType.APPLICATION_XML).
		mediaType("json", MediaType.APPLICATION_JSON);
		; 
	}
}








