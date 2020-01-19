package com.guideJavainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guideJavainuse.db.UserRepository;
import com.guideJavainuse.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping(path = "/get")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}
	
	// No me gusta como se trata la excepcion, mirar como lo tratan en otros proyectos
	@DeleteMapping(path = {"/{id}"})
	public User deleteUser(@PathVariable("id") long id) throws NotFoundException {
		//User user = userRepository.getOne(id);
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
		userRepository.deleteById(id);
		return user;
	}

}
