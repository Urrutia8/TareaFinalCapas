package com.rdr.capas.services;

import java.util.List;

import com.rdr.capas.domain.Branch;

public interface BranchInterface {
	public List<Branch> findAll();
	public Branch getOne(Integer id);	
	public void create(Branch branch);
	public void update(Branch branch);
	public void deleteById(Integer id);
}