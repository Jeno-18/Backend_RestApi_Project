package com.GreatLearning.RestApi.Entity;

import java.time.LocalDate;
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

import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="USERNAME", columnDefinition = "VARCHAR(50)")
	String username;
	@Column(name="PASSWORD", columnDefinition = "VARCHAR(50)")
	String password;

	@Column(name="ACCOUNTEXPIRYDATE", nullable = false)
	LocalDate accountExpiryDate;
	@Column(name="ACCOUNTLOCKEDSTATUS", columnDefinition = "INT")
	int accountLockedStatus;
	@Column(name="CREDENTIALSEXPIRYDATE", nullable = false)
	LocalDate credentialsExpiryDate;
	@Column(name="ACCOUNTENABLEDSTATUS", columnDefinition = "INT")
	int accountEnabledStatus;
	
	public User(String username, String password) {					
		this.username = username;
		this.password = password;
	}

	public User() {}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	List<Roles> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getAccountExpiryDate() {
		return accountExpiryDate;
	}

	public void setAccountExpiryDate() {
		this.accountExpiryDate = LocalDate.now().plusYears(1);
	}

	public int getAccountLockedStatus() {
		return accountLockedStatus;
	}

	public void setAccountLockedStatus(int accountLockedStatus) {
		this.accountLockedStatus = 1;
	}

	public LocalDate getCredentialsExpiryDate() {
		return credentialsExpiryDate;
	}

	public void setCredentialsExpiryDate() {
	    this.credentialsExpiryDate = LocalDate.now().plusYears(1);
	}

	public int getAccountEnabledStatus() {
		return accountEnabledStatus;
	}

	public void setAccountEnabledStatus(int accountEnabledStatus) {
		this.accountEnabledStatus = 1;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}


}