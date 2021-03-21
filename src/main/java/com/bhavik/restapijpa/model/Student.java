package com.bhavik.restapijpa.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	int age;
	String department;

}
