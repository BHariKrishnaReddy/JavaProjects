package com.example.restfulWebService.restfulWebServices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		return http.build();
//	}   *** This Method will bypass the auto spring sec {will not ask for any user auth
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// All requests will be authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		
		// if request is not authenticated, a web page is shown
		http.httpBasic(withDefaults());
		// with this line of code a popUp is show top pass your creds
		
		//CSRF ->POST or PUT
		http.csrf().disable();
		
		return http.build();
	}
}
