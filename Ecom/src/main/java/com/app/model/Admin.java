package com.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aId;
	@NotNull(message = "name can not be null")
	@Size(min=3, message="name length should be atleast 3")
	private String name;
	@Column(unique = true)
	@NotNull
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Size(min = 8, message = "Password should be at least 8 characters.")
	private String password;
	@NotNull
	@Size(min=3, message="city length should be atleast 3")
	private String city;
	private String role;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "admin")
	@JsonManagedReference
	private List<Category> categories;
}
