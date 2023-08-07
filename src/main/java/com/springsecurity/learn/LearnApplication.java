package com.springsecurity.learn;

import com.springsecurity.learn.model.User;
import com.springsecurity.learn.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan("com.springsecurity.learn")
public class LearnApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("arpit");
		user.setEmail("arpit@test.com");
		user.setPassword(passwordEncoder.encode("arpit"));
		user.setRole("ROLE_USER");

		this.userRepository.save(user);
		User user2 = new User();
		user2.setUsername("banz");
		user2.setEmail("banz@test.com");
		user2.setPassword(passwordEncoder.encode("banz"));
		user2.setRole("ROLE_ADMIN");
		this.userRepository.save(user2);
	}
}
