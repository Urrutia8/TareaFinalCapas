package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(schema="public",name="empleado")
public class Empleado {
	@Id
	@GeneratedValue(generator="usuario_id_usuario_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "public.usuario_id_usuario_seq", sequenceName = "public.usuario_id_usuario_seq")
	@Column(name="codigo")
	Integer codigo;
	@Column(name="nombre")
	@NotBlank
	String nombre;
	@Column(name="edad")
	@Min(18)
	Integer edad;
	@Column(name="genero")
	Character genero;
	@Column(name="estado")
	@NotNull
	Boolean estado;
	@Column(name="id_sucursal")
	@Min(0)
	Integer id_sucursal;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public Integer getId_sucursal() {
		return id_sucursal;
	}
	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

}
