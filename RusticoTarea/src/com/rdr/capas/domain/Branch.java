package com.rdr.capas.domain;

import java.sql.Time;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(schema="public", name="branch")
public class Branch {
	
	@Id
	@GeneratedValue(generator="branch_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "branch_id_seq", sequenceName = "public.branch_id_seq", allocationSize=1)
	private Integer id;
	
	@NotEmpty(message="No puede estar vacío")
	private String name;
	
	@NotEmpty(message="No puede estar vacío")
	private String address;
	
	@NotEmpty(message = "No puede estar vacío")
	private String schedules;
	
	@Column(name = "number_of_tables")
	@Min(1)
	private int numberOfTables;
	
	@Column(name = "manager_name")
	@NotEmpty(message="No puede estar vacio")
	@Pattern(regexp = "[A-Za-z ]+", message="No puede contener numeros")
	private String managerName;
		
	@OneToMany(mappedBy= "branch", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval=true)
	private List<Employee> employees;
	
	public Branch() {		
	}

	public String getAddress() {
		return address;
	}
	
	
	public String getManagerName() {
		return managerName;
	}
	
	public int getNumberOfTables() {
		return numberOfTables;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	public void setNumberOfTables(int numberOfTables) {
		this.numberOfTables = numberOfTables;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public String getSchedules() {
		return schedules;
	}
	
	public void setSchedules(String schedules) {
		this.schedules = schedules;
	}
	
}
