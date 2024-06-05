package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	
	public Optional<Book> getBook(@RequestParam UUID bookId) {
		return bookRepository.findById(bookId);
	}
	
	
	public String createBook(@RequestBody Book book){
		
		bookRepository.saveAndFlush(book);
		
		String responseMessage = null;
		
		if(bookRepository.findById(book.getId()).isPresent()) {
			responseMessage = String.format("This is the post and the object is: %s", book.toString());
		}
		else {
			responseMessage = String.format("Failed to create the book");
		}
		
		return responseMessage;
	}
	
	
	public String updateBook(Book book){
		
		bookRepository.save(book);
		String responseMessage = null;
		
		if (book.equals(bookRepository.findById(book.getId()).get())) {
			responseMessage = String.format("This is the put and the object is: %s", book.toString());
		}
		else {
			responseMessage = String.format("Failed to update the book");
		}
		
		return responseMessage;
	}
	
	
	public String deleteBook(Book book){
		
		bookRepository.delete(book);
		String responseMessage = null;
		
		if(!bookRepository.findById((book.getId())).isPresent()) {
			responseMessage = String.format("Deleting license with id %s", book);
		}
		else {
			responseMessage = String.format("Failed to delete the book");
		}

		return responseMessage;
	}

	
	public String deleteBookById(@RequestParam UUID bookId){
		
		bookRepository.deleteById(bookId);
		String responseMessage = null;
		
		if(!bookRepository.findById((bookId)).isPresent()) {
			responseMessage = String.format("Deleting by id license with id %s", bookId);
		}
		else {
			responseMessage = String.format("Failed to delete the book");
		}

		return responseMessage;
	}
	
}
