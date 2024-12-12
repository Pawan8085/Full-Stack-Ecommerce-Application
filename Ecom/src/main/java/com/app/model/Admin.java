package com.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aId;
	private String name;
	@Column(unique = true)
	@NotNull
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String city;
	private String role;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
	@JsonManagedReference
	private List<Category> categories;
}
