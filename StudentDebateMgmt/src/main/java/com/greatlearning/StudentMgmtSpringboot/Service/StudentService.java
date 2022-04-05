package com.greatlearning.StudentMgmtSpringboot.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.StudentMgmtSpringboot.entity.Student;

@Service
public interface StudentService {
	
	public void save(Student st );
	
	public List<Student> readAll();
	
	public Student readById(int id);
	
	public void delete(int id);	

}
