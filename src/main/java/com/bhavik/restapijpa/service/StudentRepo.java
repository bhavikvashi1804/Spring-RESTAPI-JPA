package com.bhavik.restapijpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhavik.restapijpa.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
