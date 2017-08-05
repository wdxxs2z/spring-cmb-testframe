package com.example.testframework.testng;

import org.testng.annotations.Test;

@Test(groups = {"class-group"})
public class GroupsTest {
	
	@Test(groups = {"group1", "group2"})
    public void testMethod1() {
    }

    @Test(groups = {"group1", "group2"})
    public void testMethod2() {
    }

    @Test(groups = {"group1"})
    public void testMethod3() {
    }

}
