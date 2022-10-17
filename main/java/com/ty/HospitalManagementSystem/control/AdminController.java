package com.ty.HospitalManagementSystem.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Admin;
import com.ty.HospitalManagementSystem.dto.Login;
import com.ty.HospitalManagementSystem.service.AdminService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;


@RestController
public class AdminController {
	@Autowired
	AdminService adminService;
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Validated@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	@GetMapping("/admins/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getAdmin(@RequestParam int id){
		return adminService.getAdmin(id);
	}
	@DeleteMapping("/admins")
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int id){
		return adminService.deleteAdmin(id);
	}
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int id,@Validated@RequestBody Admin admin){
		return adminService.updateAdmin(id, admin);
	}
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin(){
		return adminService.getAllAdmin();
	}
	@PostMapping("/admins/login")
	public ResponseEntity<ResponseStructure<Admin>> validateUser(@RequestBody Login login){
		return adminService.validateAdmin(login);
		
	}
	
	

}
