package com.blog.service;

import com.blog.model.User;

public interface UserService {
	public User getUser(String username);

	public void saveUser(User user);

}
