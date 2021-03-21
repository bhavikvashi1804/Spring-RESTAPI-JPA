package com.bhavik.restapijpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavik.restapijpa.model.Student;
import com.bhavik.restapijpa.service.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repository;

	@GetMapping("/studentsAPI")
	public List<Student> getAllStudents() {
		return null;
	}

	@PostMapping("/studentsAPI")
	public ResponseEntity<Object> addNewStudent(@RequestBody Student student) {
		Student s1= repository.save(student);
		System.out.println(s1);
		return new ResponseEntity("Student Added"+ s1, HttpStatus.OK);
	}

}
