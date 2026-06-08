package com.myrni.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myrni.entity.StudentEO;
import com.myrni.repository.StudentRepository;
import com.myrni.service.StudentService;

@Service
public class StudentServiceIMpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public StudentEO saveStudent(StudentEO student) {
		return studentRepository.save(student);
	}

	@Override
	public List<StudentEO> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public StudentEO getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public StudentEO updateStudent(Long id, StudentEO student) {

		StudentEO oldStudent=studentRepository.findById(id).orElse(null);
		oldStudent.setCity(student.getCity());
		oldStudent.setName(student.getName());
		
		
		return studentRepository.save(oldStudent);
	}

	@Override
	public void deleteStudent(Long id) {
		
		studentRepository.deleteById(id);
		
	}

}
