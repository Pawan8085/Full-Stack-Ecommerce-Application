package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	
	@NotNull(message = "name can not be null")
	@Size(min=3, message="name length should be atleast 3")
    private String name;
	
	@NotNull(message = "email cannot be null")
	@Column(unique = true)
	@Email(message = "")
	private String email;
	
	@Size(min = 8, message = "Password should be at least 8 characters.")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Size(min=3, message="city length should be atleast 3")
	private String city;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String role;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	@JsonManagedReference
	private Cart cart;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Orders orders;
}
