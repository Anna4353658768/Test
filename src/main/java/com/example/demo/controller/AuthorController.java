package com.example.demo.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping(value="api/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	

	@GetMapping
	public ResponseEntity<Iterable<Author>> getAuthors() {
	    return ResponseEntity.ok(authorService.getAuthors());
	}
	
	
	@GetMapping("/{authorId}")
	public ResponseEntity<Optional<Author>> getAuthor(@PathVariable("authorId") UUID authorId) {
		return ResponseEntity.ok(authorService.getAuthor(authorId));
	}
	

	@PutMapping
	public ResponseEntity<String> updateAuthor(@RequestBody Author author) {
		return ResponseEntity.ok(authorService.updateAuthor(author));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createAuthor(@RequestBody Author author) {
		return ResponseEntity.ok(authorService.createAuthor(author));
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deleteAuthor(@RequestBody Author author) {
		return ResponseEntity.ok(authorService.deleteAuthor(author));
	}
	
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<String> deleteAuthorById(@PathVariable("authorId") UUID authorId) {
		return ResponseEntity.ok(authorService.deleteAuthorById(authorId));
	}

}
