package com.kano.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kano.workshopmongo.domain.User;
import com.kano.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User annie = new User(null, "Annie Hastur", "annie@gmail.com");
		User zac = new User(null, "Z.A.C", "zac@gmail.com");
		User jayce = new User(null, "Jayce Talis", "jayce@gmail.com");
		
		userRepository.saveAll(Arrays.asList(annie, zac, jayce));
	}

}
