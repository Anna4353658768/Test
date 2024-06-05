package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	
	public Iterable<Author> getAuthors() {
		return authorRepository.findAll();
	}
	
	
	public Optional<Author> getAuthor(@RequestParam UUID authorId) {
		return authorRepository.findById(authorId);
	}
	

	public String createAuthor(@RequestBody Author author){
		
		authorRepository.saveAndFlush(author);
		String responseMessage = null;
		
		if(authorRepository.findById(author.getId()).isPresent()) {
			responseMessage = String.format("This is the post and the object is: %s", author.toString());
		}
		else {
			responseMessage = String.format("Failed to create the author");
		}
		
		return responseMessage;
	}
	
	
	public String updateAuthor(Author author){
		
		authorRepository.save(author);
		String responseMessage = null;
		
		if (author.equals(authorRepository.findById(author.getId()).get())) {
			responseMessage = String.format("This is the put and the object is: %s", author.toString());
		}
		else {
			responseMessage = String.format("Failed to update the Author");
		}
		
		return responseMessage;
	}
	
	
	public String deleteAuthor(Author author){
		
		authorRepository.delete(author);
		String responseMessage = null;
		
		if(!authorRepository.findById((author.getId())).isPresent()) {
			responseMessage = String.format("Deleting license with id %s", author);
		}
		else {
			responseMessage = String.format("Failed to delete the author");
		}

		return responseMessage;
	}

	
	public String deleteAuthorById(@RequestParam UUID authorId){
		
		authorRepository.deleteById(authorId);
		String responseMessage = null;
		
		if(!authorRepository.findById((authorId)).isPresent()) {
			responseMessage = String.format("Deleting by id license with id %s", authorId);
		}
		else {
			responseMessage = String.format("Failed to delete the author");
		}

		return responseMessage;
	}
	
}
