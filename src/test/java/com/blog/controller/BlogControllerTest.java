package com.blog.controller;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.blog.service.BlogService;
import com.blog.service.UserService;

public class BlogControllerTest {

	private MockMvc mockMvc;
	 
	@Autowired
	BlogService blogServiceMock;
	
	@Autowired
	UserService userServiceMock;
	
	@Test
	public void testBlog() {
		//bl
	}

	@Test
	public void testCreate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testView() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEdit() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSaveComment() {
		//fail("Not yet implemented");
	}

}
