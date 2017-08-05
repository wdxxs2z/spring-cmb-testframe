package com.example.testframework.testng;

import static org.junit.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.example.testframework.domain.User;
/**
 * 依赖ngtest测试
 * */
public class DependsTest {

	@Test
    public void testMethod1() {
    }

    @Test
    public void testMethod2() {
        assertNotNull(new User());
    }

    @Test(dependsOnMethods = {"testMethod1","testMethod2"},alwaysRun=true)
    public void testMethod3() {

    }
}
