package com.myrni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.myrni.entity.StudentEO;
import com.myrni.repository.StudentRepository;
import com.myrni.serviceImpl.StudentServiceIMpl;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceIMpl studentServiceIMpl;

    @Test
    void testSaveStudent() {

        StudentEO student =
                new StudentEO(1L, "Archna Chauhan", "Gorakhpur");

        when(studentRepository.save(student))
                .thenReturn(student);

        StudentEO result =
                studentServiceIMpl.saveStudent(student);

        assertNotNull(result);
        assertEquals("Archna Chauhan", result.getName());
    }

    @Test
    void testGetStudentById() {

        StudentEO student =
                new StudentEO(1L, "Archna Chauhan", "Gorakhpur");

        when(studentRepository.findById(1L))
                .thenReturn(Optional.of(student));

        StudentEO result =
                studentServiceIMpl.getStudentById(1L);

        assertNotNull(result);
        assertEquals("Archna Chauhan", result.getName());
    }
}