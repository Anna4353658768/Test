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
@Table(name = "publishers")
public class Publisher{
	
	@Id
    private UUID id;
	
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "address")
	private String address;
	
	
	@Column(name = "site")
	private String site;
	
}
