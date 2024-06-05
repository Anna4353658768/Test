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

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping(value="api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	

	@GetMapping
	public ResponseEntity<Iterable<Book>> getBooks() {
	    return ResponseEntity.ok(bookService.getBooks());
	}
	
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Optional<Book>> getBook(@PathVariable("bookId") UUID bookId) {
		return ResponseEntity.ok(bookService.getBook(bookId));
	}
	

	@PutMapping
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.updateBook(book));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.createBook(book));
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deleteBook(@RequestBody Book book) {
		return ResponseEntity.ok(bookService.deleteBook(book));
	}
	
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable("bookId") UUID bookId) {
		return ResponseEntity.ok(bookService.deleteBookById(bookId));
	}
	
}









