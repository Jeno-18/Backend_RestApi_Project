package com.GreatLearning.RestApi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employees {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="FIRST_NAME", columnDefinition = "VARCHAR(100)")
	String firstName;
	@Column(name="LAST_NAME", columnDefinition = "VARCHAR(100)")
	String lastName;
	@Column(name="EMAIL", columnDefinition = "VARCHAR(50)")
	String email;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employees [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
