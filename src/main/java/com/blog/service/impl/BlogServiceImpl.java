package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.BlogDAO;
import com.blog.dao.CommentDAO;
import com.blog.model.Blog;
import com.blog.model.Comments;
import com.blog.service.BlogService;

@Service("blogService")
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private CommentDAO commentsDAO;

	@Override
	public Blog findBlog(Long blogId) {
		
		return blogDAO.getOne(blogId);
	}

	@Override
	public void saveBlog(Blog blog) {
		blogDAO.save(blog);
		
	}

	@Override
	public List<Blog> getAllBlogs() {
		return blogDAO.findAll();
	}

	@Override
	public void saveComments(Comments comments) {
		commentsDAO.save(comments);
		
	}

	@Override
	public void deleteBlog(Long blogId) {
		blogDAO.delete(blogId);
	}
	
}
