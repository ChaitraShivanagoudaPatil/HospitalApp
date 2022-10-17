package com.ty.HospitalManagementSystem.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.HospitalManagementSystem.util.ResponseStructure;



@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> responseStructure =new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Id not found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialException(InvalidCredentialException exception){
		ResponseStructure<String> responseStructure =new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("In valid credentail");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> ref= ex.getAllErrors();
		Map<String,String> errors=new LinkedHashMap<String, String>();
		for(ObjectError error:ref) {
			String message=error.getDefaultMessage();
			String field=((FieldError) error).getField();
			errors.put(field,message);
		}
		ResponseStructure<Map<String,String>> responseStructure=new ResponseStructure<Map<String,String>>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(HttpStatus.BAD_REQUEST.name());
		responseStructure.setData(errors);
		return new ResponseEntity<Object>(responseStructure,HttpStatus.BAD_REQUEST);
	}

}
