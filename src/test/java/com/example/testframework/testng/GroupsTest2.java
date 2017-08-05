package com.example.testframework.testng;

import org.testng.annotations.Test;

@Test(groups = {"class-group"})
public class GroupsTest2 {
	@Test(groups = {"group1", "group2"})
    public void testMethod3() {
    }

    @Test(groups = {"group1", "group2"})
    public void testMethod4() {
    }

    @Test(groups = {"group1"})
    public void testMethod5() {
    }
}
