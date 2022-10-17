package com.ty.HospitalManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Entity
@Data
public class Admin {
	@Id	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String name;
	@NotNull
	private long phone;
	private String email;
	private String address;
	private String password;
	

}
