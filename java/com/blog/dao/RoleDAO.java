package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Role;
import com.blog.model.User;

@Repository("roleDAO")
public interface RoleDAO extends JpaRepository<Role, Long> {
	
	public Role findByRole(String role);

}
