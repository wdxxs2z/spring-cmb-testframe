package com.example.testframework.testng;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.example.testframework.domain.Book;

public class MethodTest {
	
	private Book spring;
	private Book docker;
	private Book microservice;
	
	@BeforeTest
	protected void setUp() {
		spring = new Book("123", "spring", 67.20, new Date(), null);
		docker = new Book("321", "docker", 90.10, new Date(), null);
		microservice = new Book("567", "microservice", 60.35, new Date(), null);
	}
	
	@Test
	public void bookBag() {
		Book bag_a[] = {spring, docker};
		Book bag_b[] = {spring, docker, microservice};
		List<Book> expected = Arrays.asList(bag_a);
		assertEquals(expected, bag_b);
	}
	
	@AfterMethod
	protected void tearDown() {
		System.out.println("完成测试");
	}

}
