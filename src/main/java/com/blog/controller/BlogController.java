package com.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.Blog;
import com.blog.model.Comments;
import com.blog.model.User;
import com.blog.service.BlogService;
import com.blog.service.UserService;
@Controller
public class BlogController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value={"/","/blogs"}, method = RequestMethod.GET)
	public ModelAndView blog(){
		logger.debug("BlogConroller:: Blog():: Start");
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		List<Blog> blogList = blogService.getAllBlogs();
		modelAndView.addObject("blogList", blogList);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("blogs");
		logger.debug("BlogConroller:: Blog():: End.");
		return modelAndView;
	}
	
	@RequestMapping(value={"/createblog"}, method = RequestMethod.GET)
	public ModelAndView create(){
		logger.debug("BlogConroller:: create():: Start");
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = new Blog();
		modelAndView.addObject("blog", blog);
		modelAndView.setViewName("createblog");
		logger.debug("BlogConroller:: Blog():: End.");
		return modelAndView;
	}
	
	@RequestMapping(value={"/viewblog/{id}"})//, method = RequestMethod.GET)
	public ModelAndView view(@PathVariable Long id){
		logger.debug("BlogConroller:: View():: Start. :: Id ::"+id);
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findBlog(id);
		
		if(blog!=null){
			modelAndView.addObject("blog", blog );
			modelAndView.addObject("newComments",new Comments());
			modelAndView.addObject("commentsList", blog.getComments());
			modelAndView.setViewName("viewblog");
		}else{
			modelAndView.setViewName("error");
		}
		logger.debug("BlogConroller:: view():: End.");
		return modelAndView;
	}
	@RequestMapping(value={"/saveblog"}, method = RequestMethod.POST)
	public String save(@Valid Blog blog,BindingResult bindingResult){
		
		if (bindingResult.hasErrors()) {
			return "createblog";
		} else {
			blog.setCreateDate(new Date());
			blog.setLastUpDt(new Date());
			blog.setUser(userService.findByUsername("admin"));
			blogService.saveBlog(blog);
			return "redirect:/blogs";
		}
	}
	
	@RequestMapping(value={"/editblog"}, method = RequestMethod.POST)
	public ModelAndView edit(@RequestParam(value = "edblogId", required = false) Long id){
		logger.debug("BlogConroller:: View():: Start. :: Id ::"+id);
		ModelAndView modelAndView = new ModelAndView();
		Blog blog = blogService.findBlog(id);
		
		modelAndView.addObject("blog", blog);
		modelAndView.setViewName("createblog");
		logger.debug("BlogConroller:: view():: End.");
		return modelAndView;
	}
	
	@RequestMapping(value={"/deleteblog"}, method = RequestMethod.POST)
	public String delete(@RequestParam(value = "delBlogId", required = false) Long id){
		logger.debug("BlogConroller:: Delete():: Start. :: Id ::"+id);
		blogService.deleteBlog(id);
		
		logger.debug("BlogConroller:: delete():: End.");
		return "redirect:/blogs";
	}
	
	@RequestMapping(value={"/savecomment"}, method = RequestMethod.POST)
	public String saveComment(@RequestParam(value = "blogId", required = false) Long id,Comments newComments){
		
		if(newComments!=null){
			newComments.setUser(userService.findByUsername("anonymous"));
			newComments.setCreateDate(new Date());
			
			Blog blog = blogService.findBlog(id);
			newComments.setBlog(blog);
			blogService.saveComments(newComments);
		}
		return "redirect:/viewblog/"+id;
	}
}
