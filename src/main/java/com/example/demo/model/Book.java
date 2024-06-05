package com.example.demo.model;

import java.util.UUID;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force=true)
@Table(name = "books")
public class Book{
	
	@Id
    private UUID id;
	
	
	@Column(name = "title")
	private String title;
	
	
	@Column(name = "code")
	private String code;
	
	
	@Column(name = "year_publish")
	private String yearPublish;
	
	
	@Column(name = "count_page")
	private Long countPage;
	
	
	@Column(name = "hardcover")
	private String hardcover;
	
	
	@Column(name = "essay")
	private String essay;
	
	
	@Column(name = "status", nullable = false)
	private Boolean status;
	
	
	@ManyToOne
    @JoinColumn(name = "author_id")
	private Author author;
	
	
	@ManyToOne
    @JoinColumn(name = "publisher_id")
	private Publisher publisher;

}
