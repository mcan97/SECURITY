package com.course.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Autowired
	private MyUDService userDService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// Authentication who
	// Authorization  yetki
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests()
				.requestMatchers("/", "", "/home")
				.permitAll()
				.requestMatchers("/admin")
				.hasAnyAuthority(Constant.ADMIN_ROLE)
				.requestMatchers("/user")
				.hasAnyAuthority(Constant.ADMIN_ROLE, Constant.USER_ROLE)
				.anyRequest()
				.authenticated()
				.and()
				.userDetailsService(userDService)
				.formLogin()
				.defaultSuccessUrl("/home")
				.and()
				.logout()
				.logoutSuccessUrl("/login")
				.and()
				.build();
	}
	
}
