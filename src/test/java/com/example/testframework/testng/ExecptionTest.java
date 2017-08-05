package com.example.testframework.testng;

import static org.junit.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.testframework.domain.Book;

public class ExecptionTest {
	
	private Book docker;
	
	@BeforeClass
	public void init() {
		docker = null;
	}

	@Test(enabled = true, expectedExceptions = NullPointerException.class)
	public void testBook(){
		assertNotNull(docker.getName());
	}
}
