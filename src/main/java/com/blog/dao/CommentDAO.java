package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Comments;

@Repository("commentDAO")
public interface CommentDAO extends JpaRepository<Comments, Long> {
	
	
}
