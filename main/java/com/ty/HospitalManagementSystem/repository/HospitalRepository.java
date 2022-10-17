package com.ty.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Hospital;


public interface HospitalRepository extends JpaRepository<Hospital,Integer>{
	
}
