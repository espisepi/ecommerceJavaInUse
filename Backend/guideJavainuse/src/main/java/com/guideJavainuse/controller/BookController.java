package com.guideJavainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guideJavainuse.db.BookRepository;
import com.guideJavainuse.model.Book;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path="books")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/get")
	public List<Book> getBook() {
		return bookRepository.findAll();
	}

}
