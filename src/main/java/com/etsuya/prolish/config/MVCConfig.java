package com.etsuya.prolish.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class MVCConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//				.allowedOriginPatterns("*")
//				.allowCredentials(true)
//				.allowedHeaders("*")
//				.allowedMethods("*")
//				.maxAge(3600);

		log.info("跨域配置：服务器");
		registry.addMapping("/**")
				.allowedOriginPatterns("https://prolish.etsuya233.top", "https://8.217.217.111")
				.allowCredentials(true)
				.allowedHeaders("*")
				.allowedMethods("*")
				.maxAge(3600);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
