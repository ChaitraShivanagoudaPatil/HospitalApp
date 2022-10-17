package com.ty.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Admin;
import com.ty.HospitalManagementSystem.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminRepository;
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Admin getAdmin(int id) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	public List<Admin> getAllAdmin(){
		return adminRepository.findAll();
	}
	public Admin updataAdmin(int id,Admin admin) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isPresent()) {
			Admin ref=opt.get();
			return ref;
		}
		else {
			return null;
		}
	}
	public String deleteAdmin(int id) {
		Optional<Admin> opt=adminRepository.findById(id);
		if(opt.isPresent()) {
			adminRepository.delete(opt.get());
			return "deleted";
		}
		return null;
	}
	
	public Admin validateAdmin(String email,String password) {
		Admin admin =adminRepository.findByEmailAndPassword(email, password);
		return admin;
		
	}
}
