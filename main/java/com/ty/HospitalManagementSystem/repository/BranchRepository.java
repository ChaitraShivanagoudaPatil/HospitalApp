package com.ty.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
