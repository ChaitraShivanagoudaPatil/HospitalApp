package com.ty.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.repository.BranchRepository;

@Repository
public class BranchDao {
@Autowired
BranchRepository branchRepository;
public Branch saveBranch(Branch branch) {
	return branchRepository.save(branch);
}

public Branch getBranch(int id) {
	Optional<Branch> opt=branchRepository.findById(id);
	if(opt.isPresent()) {
		return opt.get();
	}
	else {
		return null;
	}
}

public List<Branch> getAllBranch(){
	return branchRepository.findAll();
}
public Branch updataBranch(int id,Branch branch) {
	Optional<Branch> opt=branchRepository.findById(id);
	if(opt.isPresent()) {
		Branch ref=opt.get();
		return ref;
	}
	else {
		return null;
	}
}

public String deleteBranch(int id) {
	Optional<Branch> opt=branchRepository.findById(id);
	if(opt.isPresent()) {
		branchRepository.delete(opt.get());
		return "deleted";
	}
	return null;
}
}
