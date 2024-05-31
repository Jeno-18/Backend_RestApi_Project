package com.GreatLearning.RestApi.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAlt {
	
	@Id
	private int id;
	private String username;
    private String password;
    @ElementCollection
    private List<Roles> roles;
    
    public UserAlt() {}
    
	public UserAlt(String username, String password, List<Roles> roles) {
		this.username = username;
		this.password = password;
		this.roles = roles;
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

	public List<Roles> getRoles() {
		return new ArrayList<Roles>();
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
    
}
