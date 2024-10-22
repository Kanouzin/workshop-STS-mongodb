package com.kano.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kano.workshopmongo.domain.Post;
import com.kano.workshopmongo.domain.User;
import com.kano.workshopmongo.dto.AuthorDTO;
import com.kano.workshopmongo.dto.CommentDTO;
import com.kano.workshopmongo.repository.PostRepository;
import com.kano.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
				
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User annie = new User(null, "Annie Hastur", "annie@gmail.com");
		User zac = new User(null, "Z.A.C", "zac@gmail.com");
		User jayce = new User(null, "Jayce Talis", "jayce@gmail.com");
		
		userRepository.saveAll(Arrays.asList(annie, zac, jayce));
		
		Post post1 = new Post(null, sdf.parse("10/10/2024"), "Partiu Férias", "Vou viajar pra Porto Seguro! Até mais.", new AuthorDTO(annie) );
		Post post2 = new Post(null, sdf.parse("13/10/2024"), "Bom dia!", "Acordei bem demais!", new AuthorDTO(annie) );
		
		CommentDTO c1 = new CommentDTO("Bom descanso!", sdf.parse("11/10/2024"), new AuthorDTO(zac));
		CommentDTO c2 = new CommentDTO("Aproveite bem!", sdf.parse("12/10/2024"), new AuthorDTO(zac));
		CommentDTO c3 = new CommentDTO("Que inveja,aproveite a viagem!", sdf.parse("12/10/2024"), new AuthorDTO(jayce));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));	
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		annie.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(annie);
		
	}

}
