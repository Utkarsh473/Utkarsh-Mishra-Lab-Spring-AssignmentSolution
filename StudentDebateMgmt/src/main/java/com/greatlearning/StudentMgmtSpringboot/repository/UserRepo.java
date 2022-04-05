package com.greatlearning.StudentMgmtSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.StudentMgmtSpringboot.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.name = ?1")
	public User getUserByName (String username);
	

}
