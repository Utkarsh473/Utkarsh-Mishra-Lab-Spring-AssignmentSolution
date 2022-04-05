package com.greatlearning.StudentMgmtSpringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "Student_ID")
private int id;

@Column(name = "Name")
private String name;

@Column(name = "Department")
private String department;

@Column(name = "Country")
private String country;





}
