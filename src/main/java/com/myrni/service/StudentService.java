package com.myrni.service;

import java.util.List;

import com.myrni.entity.StudentEO;

public interface StudentService {
	
	StudentEO saveStudent(StudentEO student);

    List<StudentEO> getAllStudents();

    StudentEO getStudentById(Long id);

    StudentEO updateStudent(Long id, StudentEO student);

    void deleteStudent(Long id);

}
