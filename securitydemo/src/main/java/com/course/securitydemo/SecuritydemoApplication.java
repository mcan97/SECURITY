package com.course.securitydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.course.securitydemo.model.User;
import com.course.securitydemo.repository.UserRepository;

@SpringBootApplication
public class SecuritydemoApplication {

	/*
	 	User
	 	UserDetails password -> 
	 	UserDetailsService
	 	
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(SecuritydemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(
			UserRepository userRepository,
			PasswordEncoder encoder
			) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(encoder.encode("123"));
				admin.setRole(Constant.ADMIN_ROLE);
				
				User user= new User();
				user.setUsername("user");
				user.setPassword(encoder.encode("123"));
				user.setRole(Constant.USER_ROLE);
				
				userRepository.save(user);
				userRepository.save(admin);
			}
		};
	}

}
