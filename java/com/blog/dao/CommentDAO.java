package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Blog;
import com.blog.model.User;

@Repository("commentDAO")
public interface CommentDAO extends JpaRepository<Blog, Long> {
	
	
}
