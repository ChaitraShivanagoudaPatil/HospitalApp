package com.ty.HospitalManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.HospitalManagementSystem.dao.AdminDao;
import com.ty.HospitalManagementSystem.dto.Admin;
import com.ty.HospitalManagementSystem.dto.Login;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.exception.InvalidCredentialException;
import com.ty.HospitalManagementSystem.repository.AdminRepository;
import com.ty.HospitalManagementSystem.util.ResponseStructure;


@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	@Autowired
	AdminRepository adminRepository;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULLY CREATED");
		responseStructure.setData(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
	}
	public ResponseEntity<ResponseStructure<Admin>> getAdmin(int id){
		if(adminDao.getAdmin(id)!=null) {
			ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(adminDao.getAdmin(id));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
		
	}
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int id,Admin admin){
		Optional<Admin> opt=adminRepository.findById(id);
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		if(opt.isPresent()) {
			Admin ref=opt.get();
			ref.setName(admin.getName());
			ref.setEmail(admin.getEmail());
			ref.setPassword(admin.getPassword());
			ref.setAddress(admin.getAddress());
			ref.setPhone(admin.getPhone());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(adminDao.saveAdmin(ref));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
	}
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int id){
		if(adminDao.deleteAdmin(id)!=null) {
			ResponseStructure<String> responseStructure=new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(adminDao.deleteAdmin(id));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<List<Admin>>();
		responseStructure.setStatus(HttpStatus.OK.value());
	    responseStructure.setMessage("SUCESSFULL");
	    responseStructure.setData(adminDao.getAllAdmin());
	    return new ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> validateAdmin(Login login){
		Admin admin=adminDao.validateAdmin(login.getEmail(), login.getPassword());
		if(admin!=null) {
			
		ResponseStructure<Admin> responseStructure=new ResponseStructure<Admin>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCESSFULL");
		responseStructure.setData(admin);
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
		}else {
			throw new InvalidCredentialException("Invalid credential");
	
		}
	}

}
