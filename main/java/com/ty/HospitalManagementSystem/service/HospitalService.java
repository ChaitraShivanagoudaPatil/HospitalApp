package com.ty.HospitalManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.HospitalDao;
import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.repository.HospitalRepository;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class HospitalService {
	@Autowired
    HospitalDao hospitalDao;
	@Autowired
	HospitalRepository hospitalRepository;
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULLY CREATED");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(int id){
		if(hospitalDao.getHospital(id)!=null) {
			ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULLY CREATED");
			responseStructure.setData(hospitalDao.getHospital(id));
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
	}
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id){
		if(hospitalDao.deleteHospital(id)!=null) {
			ResponseStructure<String> responseStructure=new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(hospitalDao.deleteHospital(id));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
	}
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital){
		Optional<Hospital> opt=hospitalRepository.findById(id);
	   ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
	   if(opt.isPresent()) {
		   Hospital ref=opt.get();
		   ref.setName(hospital.getName());
		   ref.setWebsite(hospital.getWebsite());
		   responseStructure.setStatus(HttpStatus.OK.value());
		   responseStructure.setMessage("SUCESSFULL");
		   responseStructure.setData(hospitalDao.saveHospital(ref));
		   return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK); 
	   }else {
		   throw new IdNotFoundException("Id "+id+" doesn't exist");
	   }
	}
	
	
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
    ResponseStructure<List<Hospital>> responseStructure= new ResponseStructure<List<Hospital>>();
    responseStructure.setStatus(HttpStatus.OK.value());
    responseStructure.setMessage("SUCESSFULL");
    responseStructure.setData(hospitalDao.getAllHospital());
    return new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.OK);
}
}