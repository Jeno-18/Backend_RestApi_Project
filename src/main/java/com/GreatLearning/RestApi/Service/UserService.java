package com.GreatLearning.RestApi.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.RestApi.Entity.User;
import com.GreatLearning.RestApi.Repository.RolesRepository;
import com.GreatLearning.RestApi.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RolesRepository rolerepo;

	public User addUser(User newUser) {
        return userRepo.save(newUser);
	}

}