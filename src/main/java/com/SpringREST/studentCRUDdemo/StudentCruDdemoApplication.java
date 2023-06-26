package com.SpringREST.studentCRUDdemo;

import com.SpringREST.studentCRUDdemo.entity.Marks;
import com.SpringREST.studentCRUDdemo.entity.Student;
import com.SpringREST.studentCRUDdemo.repository.MarksRepository;
import com.SpringREST.studentCRUDdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class StudentCruDdemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(StudentCruDdemoApplication.class, args);
	}



}
