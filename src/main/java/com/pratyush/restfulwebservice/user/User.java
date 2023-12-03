package com.pratyush.restfulwebservice.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity(name="USER_DETAILS")
public class User {
	
@Id
@GeneratedValue
private Integer id;

@Size(min=2 , message="name should havr atleast 2 character")
//@JsonProperty("user_name")
@Column
private String name;

@Past(message="birth date should not be in future")
@Column
private LocalDate birthDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getBirthDate() {
	return birthDate;
}
public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
}
public User(Integer id, String name, LocalDate birthDate) {
	super();
	this.id = id;
	this.name = name;
	this.birthDate = birthDate;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
}
