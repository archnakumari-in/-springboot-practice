package com.myrni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrni.entity.StudentEO;
import com.myrni.service.StudentService;

// this is for testing 
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService  studentService;
	
	@PostMapping("/save-student-details")
	StudentEO saveStudent(@RequestBody StudentEO student) {
		return studentService.saveStudent(student);
		
	}

	@GetMapping("/all-student")
    List<StudentEO> getAllStudents(){
		return studentService.getAllStudents();
		
	}

	@GetMapping("/{id}")
    StudentEO getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
    	
    }

    StudentEO updateStudent(@PathVariable Long id,@RequestBody StudentEO student) {
		return studentService.updateStudent(id, student);
    	
    }

   public  String deleteStudent(Long id) {
    	studentService.deleteStudent(id);
		return "delate Student Secsesfully";
    	
    }
}
