package com.greatlearning.StudentMgmtSpringboot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "Users")
@Data
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Password")
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable
	(
		name = "users_roles",
		joinColumns = @JoinColumn(name = "User_ID"),
		inverseJoinColumns = @JoinColumn(name = "Role_ID")
	)
	private List<Roles> roles = new ArrayList<Roles>();
	
}
