package com.blog.service;

import java.util.List;

import com.blog.model.Blog;
import com.blog.model.Comments;

public interface BlogService {
	public Blog findBlog(Long blogId);

	public void saveBlog(Blog blog);
	
	public List<Blog> getAllBlogs();
	
	public void saveComments(Comments comments);
	
	public void deleteBlog(Long blogId);

}
