package com.rdr.capas.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public", name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(generator="user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "public.user_id_seq", allocationSize=1)
	private Integer id;
	
	@NotEmpty(message = "No puede estar vacio")
	@Pattern(regexp = "[A-Za-z ]+", message="No puede contener numeros")
	private String name; 
	
	@Min(18)
	@Max(65)	
    private int age;
	
	private String genre;

	private boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branch_id")
	private Branch branch;	
			
	public Employee() {
		
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	public String getDelegateStatus() {
		if (status) {
			return "Disponible";
		}
		else {
			return "No disponible";
		}
	}
	
	public Branch getBranch() {
		return branch;
	}
	
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public int getBranchMasterId () {
		
		return this.branch.getId();	
	}
	
	public void setBranchMasterId (int id) {
		this.branch.setId(id);
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}