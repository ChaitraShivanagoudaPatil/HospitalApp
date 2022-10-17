package com.ty.HospitalManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ty.HospitalManagementSystem.dao.BranchDao;
import com.ty.HospitalManagementSystem.dto.Branch;
import com.ty.HospitalManagementSystem.exception.IdNotFoundException;
import com.ty.HospitalManagementSystem.repository.BranchRepository;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@Service
public class BranchService {
    @Autowired
	BranchDao branchDao;
    @Autowired
    BranchRepository branchRepository;
    public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch){
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCESSFULLY CREATED");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}
    
    public ResponseEntity<ResponseStructure<Branch>> getBranch(int id){
		if(branchDao.getBranch(id)!=null) {
			ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULLY CREATED");
			responseStructure.setData(branchDao.getBranch(id));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}}
    public ResponseEntity<ResponseStructure<String>> deleteBranch(int id){
		if(branchDao.deleteBranch(id)!=null) {
			ResponseStructure<String> responseStructure=new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCESSFULL");
			responseStructure.setData(branchDao.deleteBranch(id));
			return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id "+id+" doesn't exist");
		}
	}
    
    public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch){
		Optional<Branch> opt=branchRepository.findById(id);
	   ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
	   if(opt.isPresent()) {
		   Branch ref=opt.get();
		   ref.setCity(branch.getCity());
		   ref.setAddress(branch.getAddress());
		   ref.setPhone(branch.getPhone());
		   responseStructure.setStatus(HttpStatus.OK.value());
		   responseStructure.setMessage("SUCESSFULL");
		   responseStructure.setData(branchDao.saveBranch(ref));
		   return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK); 
	   }else {
		   throw new IdNotFoundException("Id "+id+" doesn't exist");
	   }
	}
    
    public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch(){
        ResponseStructure<List<Branch>> responseStructure= new ResponseStructure<List<Branch>>();
        responseStructure.setStatus(HttpStatus.OK.value());
        responseStructure.setMessage("SUCESSFULL");
        responseStructure.setData(branchDao.getAllBranch());
        return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
    }
}