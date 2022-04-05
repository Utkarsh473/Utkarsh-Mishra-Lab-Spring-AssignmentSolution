package com.greatlearning.StudentMgmtSpringboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.StudentMgmtSpringboot.entity.User;
import com.greatlearning.StudentMgmtSpringboot.repository.UserRepo;
import com.greatlearning.StudentMgmtSpringboot.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepo usr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = usr.getUserByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		else {
			return new MyUserDetails(user);

		}

	}

}
