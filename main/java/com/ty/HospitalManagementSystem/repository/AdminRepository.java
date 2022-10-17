package com.ty.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.HospitalManagementSystem.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);

}
