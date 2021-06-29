package com.CInemaaProject.MovieService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

//import com.CInemaaProject.MovieService.Model.TheatreServiceProxy;

/*@SpringBootApplication(scanBasePackages={
		"com.CInemaaProject.MovieService.Model", "com.CInemaaProject.MovieService.repository",
		"com.CInemaaProject.MovieService.MovieService"})*/
@SpringBootApplication
public class MovieServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
