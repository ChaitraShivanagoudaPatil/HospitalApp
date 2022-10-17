package com.ty.HospitalManagementSystem.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.HospitalManagementSystem.dto.Hospital;
import com.ty.HospitalManagementSystem.service.HospitalService;
import com.ty.HospitalManagementSystem.util.ResponseStructure;

@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/hospitls")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.saveHospital(hospital);
	}
	@GetMapping("/hospitals/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> getHospital(@PathVariable int id){
		return hospitalService.getHospital(id);
	}
	@DeleteMapping("/hospitals")
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@RequestParam int id){
		return hospitalService.deleteHospital(id);
	}
	@GetMapping("/hospitals")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital(){
		return hospitalService.getAllHospital();
	}
	
	@PutMapping("/hospitals")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestParam int id,@RequestBody Hospital hospital){
		return hospitalService.updateHospital(id, hospital);
	}

}
