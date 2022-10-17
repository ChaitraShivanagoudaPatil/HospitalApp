package com.ty.HospitalManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.repository.HospitalRepository;


@Repository
public class HospitalDao {
	@Autowired
	HospitalRepository hospitalRepository;
	public Hospital  saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	public Hospital getHospital(int id) {
		Optional<Hospital> opt=hospitalRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			return null;
		}
	}
	public List<Hospital> getAllHospital(){
		return hospitalRepository.findAll();
	}
	public Hospital updateHospital(int id,Hospital hospital) {
		Optional<Hospital> opt=hospitalRepository.findById(id);
		if(opt.isPresent()) {
			Hospital ref=opt.get();
			return ref;
		}
		else {
			return null;
		}
	}
	public String deleteHospital(int id) {
		Optional<Hospital> opt=hospitalRepository.findById(id);
		if(opt.isPresent()) {
			hospitalRepository.delete(opt.get());
			return "deleted";
		}
		else {
			return null;
		}
		
	}
	
	

}
