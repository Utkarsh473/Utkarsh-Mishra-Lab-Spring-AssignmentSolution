package com.greatlearning.StudentMgmtSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.StudentMgmtSpringboot.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
