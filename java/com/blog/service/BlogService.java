package com.blog.service;

import java.util.List;

import com.blog.model.Blog;

public interface BlogService {
	public Blog findBlog(Long blogId);

	public void saveBlog(Blog blog);
	
	public List<Blog> getAllBlogs();

}
