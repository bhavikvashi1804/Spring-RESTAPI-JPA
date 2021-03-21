package com.bhavik.restapijpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhavik.restapijpa.model.Student;
import com.bhavik.restapijpa.service.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repository;

	@GetMapping("/studentsAPI")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = repository.findAll();

		if (students.isEmpty()) {
			return new ResponseEntity("No records found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity(students, HttpStatus.OK);
		}
	}

	@GetMapping("/studentsAPI/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable int id) {
		try {
			Student s1 = repository.findById(id).get();
			System.out.println(s1);
			return new ResponseEntity(s1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/studentsAPI")
	public ResponseEntity<Object> addNewStudent(@RequestBody Student student) {
		Student s1 = repository.save(student);
		System.out.println(s1);
		return new ResponseEntity("Student Added: " + s1, HttpStatus.OK);
	}

	@PutMapping("/studentsAPI")
	public ResponseEntity<Object> updateStudent(@RequestBody Student s) {
		try {
			Student s1 = repository.save(s);
			return new ResponseEntity("Update Student record done: " + s1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/studentsAPI/{id}")
	public ResponseEntity<Object> deleteOneStudents(@PathVariable int id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity("Student record is deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/studentsAPI")
	public ResponseEntity<Object> deleteAllStudents() {
		try {
			repository.deleteAll();
			return new ResponseEntity("Student records are deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
