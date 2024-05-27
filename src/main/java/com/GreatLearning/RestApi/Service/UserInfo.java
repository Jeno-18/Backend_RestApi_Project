package com.GreatLearning.RestApi.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.GreatLearning.RestApi.Entity.Roles;
import com.GreatLearning.RestApi.Entity.User;

@Service
public class UserInfo implements UserDetails {

	User user;

	public UserInfo(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> roles = user.getRoles(); // ROLE_ ROLE_USER
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (Roles role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName())); // ROLE_ADMIN ROLE_MANAGER
		}

		return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		LocalDate accExpiryDate = user.getAccountExpiryDate();
		LocalDate todaysDate = LocalDate.now();
		if (accExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getAccountLockedStatus() == 1 ? true : false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getCredentialsExpiryDate().isAfter(LocalDate.now()) ? true : false;
	}

	@Override
	public boolean isEnabled() {
		int enabledStatus = user.getAccountEnabledStatus();
		if (enabledStatus == 1)
			return true;
		else
			return false;

	}

}