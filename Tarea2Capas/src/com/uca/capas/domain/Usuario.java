package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(schema="public",name="usuario")
public class Usuario {
	@Id
	@Column(name="id_usuario")
	Integer id;
	
	@Column(name="usuario")
	@NotBlank
	String usuario;
	
	@Column(name="clave")
	@NotBlank
	String clave;
	
	

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String clave) {
		super();
		this.usuario = usuario;
		this.clave = clave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
