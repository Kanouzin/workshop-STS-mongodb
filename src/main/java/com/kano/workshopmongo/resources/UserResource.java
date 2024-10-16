package com.kano.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kano.workshopmongo.domain.User;

@RestController
@RequestMapping(value ="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User annie = new User("1", "Annie Hastur", "annie@gmail.com");
		User zac = new User("1", "Z.A.C", "zac@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(annie, zac));
		return ResponseEntity.ok().body(list);
	}
}
