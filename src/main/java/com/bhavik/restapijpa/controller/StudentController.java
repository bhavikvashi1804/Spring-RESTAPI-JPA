package com.bhavik.restapijpa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavik.restapijpa.model.Student;

@RestController
public class StudentController {
	
	
	@GetMapping("/studentsAPI")
	public List<Student> getAllStudents(){
		return null;
	}
	
	@PostMapping("/studentsAPI")
	public ResponseEntity<Object> addNewStudent(){
		
		return new ResponseEntity("Student Added",HttpStatus.OK);
	}

}
