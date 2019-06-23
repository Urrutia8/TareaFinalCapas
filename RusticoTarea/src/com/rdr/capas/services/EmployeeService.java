package com.rdr.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdr.capas.domain.Employee;
import com.rdr.capas.repositories.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeInterface {

	@Autowired
	EmployeeRepository eRepository;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getOne(Integer id) {
		// TODO Auto-generated method stub
		return eRepository.getOne(id);
	}

	@Override
	public void create(Employee employee) {
		// TODO Auto-generated method stub
		eRepository.save(employee);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		eRepository.deleteById(id);
		
	}

}
