package com.grp11.Domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.grp11.address.AddressDomain;

@Entity

public class UserDomain {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message="Please enter Your Firstname")
	@Size(min=2, max=30,message="Please enter name with length min 2 and max 30")
	private String firstName;
	
	@NotEmpty(message="Please enter Your Lastname")
	@Size(min=2, max=30,message="Please enter name with length min 2 and max 30")	
	private String lastName;
	
	@NotEmpty(message="Please enter Your Username")
	@Size(min=2, max=30,message="Please enter name with length min 2 and max 30")		
	private String username;
	
	@NotEmpty(message="Please enter Your Password")
	private String password;
	
	@NotEmpty(message="Please enter street")
	private String street;
	
	@NotEmpty(message="Please enter city")
	private String city;
	
	@NotEmpty(message="Please enter zip")
	private String zip;
	
	@NotEmpty(message="Please enter email")
	private String email;
	
	@NotEmpty(message="Please enter phone")
	private String phone;
	
	private String role;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
		
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
	
}
