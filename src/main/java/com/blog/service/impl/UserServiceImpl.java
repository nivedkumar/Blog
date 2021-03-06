package com.blog.service.impl;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.dao.RoleDAO;
import com.blog.dao.UserDAO;
import com.blog.model.Role;
import com.blog.model.User;
import com.blog.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findByUsername(String username) {
		
		return userDAO.findByUsername(username);
	}
	
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleDAO.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userDAO.save(user);
	}

}
