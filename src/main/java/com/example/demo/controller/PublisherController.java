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

import com.example.demo.model.Publisher;
import com.example.demo.service.PublisherService;

@RestController
@RequestMapping(value="api/publishers")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	

	@GetMapping
	public ResponseEntity<Iterable<Publisher>> getPublishers() {
	    return ResponseEntity.ok(publisherService.getPublishers());
	}
	
	
	@GetMapping("/{publisherId}")
	public ResponseEntity<Optional<Publisher>> getPublisher(@PathVariable("publisherId") UUID publisherId) {
		return ResponseEntity.ok(publisherService.getPublisher(publisherId));
	}
	

	@PutMapping
	public ResponseEntity<String> updatePublisher(@RequestBody Publisher publisher) {
		return ResponseEntity.ok(publisherService.updatePublisher(publisher));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createPublisher(@RequestBody Publisher publisher) {
		return ResponseEntity.ok(publisherService.createPublisher(publisher));
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deletePublisher(@RequestBody Publisher publisher) {
		return ResponseEntity.ok(publisherService.deletePublisher(publisher));
	}
	
	
	@DeleteMapping("/{publisherId}")
	public ResponseEntity<String> deletePublisherById(@PathVariable("publisherId") UUID publisherId) {
		return ResponseEntity.ok(publisherService.deletePublisherById(publisherId));
	}

}
