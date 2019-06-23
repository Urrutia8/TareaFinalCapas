package com.rdr.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="user")
public class User {
	
	@Id
	@GeneratedValue(generator="user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "public.user_id_seq", allocationSize=1)
	private Integer id;
	
	@NotEmpty(message="No puede estar vacio")	
	private String username;

	@NotEmpty(message="No puede estar vacio")
	private String password;
		
	public User() {
		
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername(){
		return this.username;
	}	

	public String getPassword(){
		return this.password;
	}	
	
}