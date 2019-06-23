package com.rdr.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.capas.domain.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
