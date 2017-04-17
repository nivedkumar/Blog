package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.User;

@Repository("userDAO")
public interface UserDAO extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
