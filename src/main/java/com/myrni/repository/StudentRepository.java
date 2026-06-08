package com.myrni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myrni.entity.StudentEO;

public interface StudentRepository  extends JpaRepository<StudentEO, Long>{

}
