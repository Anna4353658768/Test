package com.example.demo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force=true)
@Table(name = "authors")
public class Author{

	@Id
    private UUID id;

	
	@Column(name = "surname")
	private String surname;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "patronymic")
	private String patronymic;
	
}
