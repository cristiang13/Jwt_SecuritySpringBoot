package com.app.jwtSecurity;

import java.util.ArrayList;

import com.app.jwtSecurity.model.Role;
import com.app.jwtSecurity.model.User;
import com.app.jwtSecurity.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JwtSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtSecurityApplication.class, args);
	}
 
	@Bean
	CommandLineRunner run(UserService userService){
		return args->{
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Jhon Casas","jhon","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"alvaro martinez","alvaro","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"daniela solir","daniela","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"maria ponte","maria","1234",new ArrayList<>()));

			userService.addRoleToUser("jhon","ROLE_USER" );
			userService.addRoleToUser("jhon", "ROLE_MANAGER");
			userService.addRoleToUser("alvaro", "ROLE_MANAGER");
			userService.addRoleToUser("daniela", "ROLE_ADMIN");
			userService.addRoleToUser("maria", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("maria", "ROLE_ADMIN");
			userService.addRoleToUser("maria", "ROLE_USER");



		};
	}
}
