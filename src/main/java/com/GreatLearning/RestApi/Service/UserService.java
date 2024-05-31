package com.GreatLearning.RestApi.Service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.RestApi.Entity.User;
import com.GreatLearning.RestApi.Entity.UserAlt;
import com.GreatLearning.RestApi.Repository.RolesRepository;
import com.GreatLearning.RestApi.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RolesRepository rolerepo;

	public User addUser(UserAlt newUser) {
		User user = new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        
        user.setRoles(newUser.getRoles());
        return userRepo.save(user);
	}

}
