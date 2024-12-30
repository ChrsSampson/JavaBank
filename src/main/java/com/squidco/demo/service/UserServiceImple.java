package com.squidco.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squidco.demo.entity.User;
import com.squidco.demo.entity.User.UserRole;
import com.squidco.demo.repository.UserRepo;

import java.util.List;
import java.util.Optional;
import java.security.SecureRandom;

@Service
public class UserServiceImple implements UserService {
    
    private UserRepo userRepo;

    // @Autowired
    public UserServiceImple (UserRepo repo) {
        userRepo = repo;
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

	@Override
	public User save(User user) {
        // user.setId(0); // forces creation of new record;
        user.setRole(UserRole.user);
        
        // password hashing and dehashing will be handled by spring security at some point

        System.out.println("Trying to save: " + user.toString());

		return userRepo.save(user);
	}

    @Override
    public User findById(long id) {
        Optional<User> result = userRepo.findById(id);

        // User fallback = null;
        
        if(result.isPresent()){
            return result.get();
        } else {
            return null;
        }
    }

}
