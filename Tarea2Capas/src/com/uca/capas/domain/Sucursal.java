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
import javax.validation.constraints.Pattern;

@Entity
@Table(schema="public",name="sucursal")
public class Sucursal {
	@Id
	@GeneratedValue(generator="sucursal_codigo_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "public.sucursal_codigo_seq", sequenceName = "public.sucursal_codigo_seq")
	@Column(name="codigo")
	Integer codigo;
	@Column(name="nombre")
	@NotBlank
	String nombre;
	@Column(name="ubicacion")
	@NotBlank
	String ubicacion;
	@Column(name="nmesa")
	@Min(value = 1, message = "El valor minimo de mesas es 1")
	Integer nMesa;
	@Column(name="nomgerente")
	@NotBlank
	String nomGerente;
	@Column(name="horario_ini")
	@Pattern(regexp="([0-9]|1[0-9]|2[0-4]):[0-5][0-9]")
	String horarioInicio;
	@Column(name="horario_fin")
	@Pattern(regexp="([0-9]|1[0-9]|2[0-4]):[0-5][0-9]")
	String horarioFin;
	
	public Sucursal() {
		super();
	}

	public Sucursal(String nombre, String ubicacion, Integer nMesa, String nomGerente, String horarioInicio,
			String horarioFin) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.nMesa = nMesa;
		this.nomGerente = nomGerente;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
	}

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

	
	public String getUbicacion() {
		return ubicacion;
	}

	
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	public Integer getnMesa() {
		return nMesa;
	}

	
	public void setnMesa(Integer nMesa) {
		this.nMesa = nMesa;
	}

	
	public String getNomGerente() {
		return nomGerente;
	}

	
	public void setNomGerente(String nomGerente) {
		this.nomGerente = nomGerente;
	}

	
	public String getHorarioInicio() {
		return horarioInicio;
	}

	
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	
	public String getHorarioFin() {
		return horarioFin;
	}

	
	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
}
