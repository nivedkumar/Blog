package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.Blog;
import com.blog.model.User;

@Repository("blogDAO")
public interface BlogDAO extends JpaRepository<Blog, Long> {
	

}
