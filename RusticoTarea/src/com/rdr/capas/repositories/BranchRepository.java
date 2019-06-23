package com.rdr.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.capas.domain.Branch;



public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
}
