package com.rdr.capas.services;

import java.util.List;


import com.rdr.capas.domain.Employee;

public interface EmployeeInterface {
	public List<Employee> findAll();
	public Employee getOne(Integer id);	
	public void create(Employee employee);
	public void update(Employee employee);
	public void deleteById(Integer id);
}
