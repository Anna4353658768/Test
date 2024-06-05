package com.example.demo.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Publisher;
import com.example.demo.repository.PublisherRepository;

@Service
public class PublisherService {

	@Autowired
	private PublisherRepository publisherRepository;
	
	
	public Iterable<Publisher> getPublishers() {
		return publisherRepository.findAll();
	}
	
	
	public Optional<Publisher> getPublisher(@RequestParam UUID publisherId) {
		return publisherRepository.findById(publisherId);
	}
	
	
	public String createPublisher(@RequestBody Publisher publisher){
		
		publisherRepository.saveAndFlush(publisher);
		String responseMessage = null;
		
		if(publisherRepository.findById(publisher.getId()).isPresent()) {
			responseMessage = String.format("This is the post and the object is: %s", publisher.toString());
		}
		else {
			responseMessage = String.format("Failed to create the publisher");
		}
		
		return responseMessage;
	}
	
	
	public String updatePublisher(Publisher publisher){
		
		publisherRepository.save(publisher);
		String responseMessage = null;
		
		if (publisher.equals(publisherRepository.findById(publisher.getId()).get())) {
			responseMessage = String.format("This is the put and the object is: %s", publisher.toString());
		}
		else {
			responseMessage = String.format("Failed to update the publisher");
		}
		
		return responseMessage;
	}
	
	
	public String deletePublisher(Publisher publisher){
		
		publisherRepository.delete(publisher);
		String responseMessage = null;
		
		if(!publisherRepository.findById((publisher.getId())).isPresent()) {
			responseMessage = String.format("Deleting license with id %s", publisher);
		}
		else {
			responseMessage = String.format("Failed to delete the publisher");
		}

		return responseMessage;
	}

	
	public String deletePublisherById(@RequestParam UUID publisherId){
		
		publisherRepository.deleteById(publisherId);
		String responseMessage = null;
		
		if(!publisherRepository.findById((publisherId)).isPresent()) {
			responseMessage = String.format("Deleting by id license with id %s", publisherId);
		}
		else {
			responseMessage = String.format("Failed to delete the Publisher");
		}

		return responseMessage;
	}
	
}
