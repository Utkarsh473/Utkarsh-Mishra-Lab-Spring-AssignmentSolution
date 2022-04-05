package com.greatlearning.StudentMgmtSpringboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.StudentMgmtSpringboot.entity.Student;
import com.greatlearning.StudentMgmtSpringboot.repository.StudentRepo;

@Repository
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo stuRepo;
	
	public void save(Student st)
	{
		stuRepo.save(st);
	}
	
	public List<Student> readAll()
	{
		List<Student> s = stuRepo.findAll();
		
		return s; 
	}
	
	public Student readById(int id)
	{
		Student s = stuRepo.findById(id).get();
		
		return s;
	}
	
	public void delete(int id) {
		
		Student s = stuRepo.findById(id).get();
		
		stuRepo.delete(s);
	}

}
