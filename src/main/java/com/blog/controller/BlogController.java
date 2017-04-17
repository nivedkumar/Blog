package com.blog.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.Blog;
import com.blog.model.Comments;
import com.blog.model.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;
@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/","/blogs"}, method = RequestMethod.GET)
	public ModelAndView blog(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		List<Blog> blogList = blogService.getAllBlogs();
		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("blogs");
		return modelAndView;
	}
	
	@RequestMapping(value={"/createblog"}, method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = new Blog();
		modelAndView.addObject("blog", blog);
		modelAndView.setViewName("createblog");
		return modelAndView;
	}
	
	@RequestMapping(value={"/viewblog"}, method = RequestMethod.GET)
	public ModelAndView view(Long blogId){
		ModelAndView modelAndView = new ModelAndView();
		Comments comments  = new Comments();
		modelAndView.addObject("comments", comments);
		modelAndView.setViewName("viewblog");
		return modelAndView;
	}
	@RequestMapping(value={"/saveblog"}, method = RequestMethod.POST)
	public ModelAndView save(Blog blog){

		System.out.println(blog.getTitle());
		blog.setCreateDate(new Date());
		blog.setLastUpDt(new Date());
		blog.setUser(userService.getUser("admin"));
		blogService.saveBlog(blog);
		System.out.println("Blog Saved");
		ModelAndView modelAndView = new ModelAndView();
		List<Blog> blogList = blogService.getAllBlogs();
		modelAndView.addObject("blogList", blogList);
		modelAndView.setViewName("blogs");
		return modelAndView;
	}
}
