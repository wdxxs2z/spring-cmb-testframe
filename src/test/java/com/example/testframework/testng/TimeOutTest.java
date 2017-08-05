package com.example.testframework.testng;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.testframework.domain.Book;

public class TimeOutTest {
	
	private Book docker;
	
	@BeforeClass
	public void init() {
		docker = new Book("sdaf", "docker", 12.20, new Date(), null);
	}
	
	@Test(timeOut=10)
	public void testBook() {
		assertNotNull(docker);
		assertEquals(docker.getName(), "docker");
	}

}
