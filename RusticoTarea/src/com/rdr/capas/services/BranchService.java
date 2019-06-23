package com.rdr.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdr.capas.domain.Branch;
import com.rdr.capas.repositories.BranchRepository;

@Service
public class BranchService implements BranchInterface{

	
	@Autowired
	BranchRepository bRepository;
	
	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return bRepository.findAll();
	}

	@Override
	public Branch getOne(Integer id) {
		// TODO Auto-generated method stub
		return bRepository.getOne(id);
	}

	@Override
	public void update(Branch branch) {
		// TODO Auto-generated method stub
		bRepository.save(branch);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		bRepository.deleteById(id);
	}

	@Override
	public void create(Branch branch) {
		// TODO Auto-generated method stub
		bRepository.save(branch);
	}

}
