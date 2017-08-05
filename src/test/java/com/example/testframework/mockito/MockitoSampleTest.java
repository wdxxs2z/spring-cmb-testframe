package com.example.testframework.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.example.testframework.domain.User;
import com.example.testframework.service.UserService;
import com.example.testframework.service.UserServiceImpl;

public class MockitoSampleTest {
	
	//对接口进行模拟
	UserService mockUserService = mock(UserService.class);
	//对类进行模拟
	UserServiceImpl mockServiceImpl = mock(UserServiceImpl.class);
	
	//基于注解模拟类对象
    @Mock 
    User mockUser;

    @BeforeClass
    public void initMocks() {
    	//初始化当前测试类所有@mock注解模拟对象
        MockitoAnnotations.initMocks(this);
    }

    /**
     * 设定mock对象的期望行为及返回值
     * 通过when(mock.someMethod()).thenReturn(value)来设定mock对象的某个方法
     * 调用时的返回值，但有限制条件，对于static和final修饰的方法是无法进行设定
     * 的。
     * */
	@Test
	public void testMockInterface() {
		//对方法设定返回值
		when(mockUserService.findUserByUserName("tom")).thenReturn(
				new User("tom", "1234"));
		doReturn(true).when(mockUserService).hasMatchUser("tom", "1234");

		//对void空方法进行方法预期设定
		User u = new User("John", "1234");
		doNothing().when(mockUserService).registerUser(u);

		//执行方法调用
		User user = mockUserService.findUserByUserName("tom");
		boolean isMatch = mockUserService.hasMatchUser("tom","1234");
		mockUserService.registerUser(u);

		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);

		//Mock对象一旦建立便会自动记录自己的交互行为，所以我们可以有选择的
		//对其交互行为进行验证。
		
		//验证交互行为，方法是verify(mock对象).xxx方法
		verify(mockUserService).findUserByUserName("tom");
		//只执行一次
		verify(mockUserService, times(1)).findUserByUserName("tom");
		//至少执行一次
		verify(mockUserService, atLeastOnce()).findUserByUserName("tom");
		verify(mockUserService, atLeast(1)).findUserByUserName("tom");
		//最多验证一次
		verify(mockUserService, atMost(1)).findUserByUserName("tom");
		
		verify(mockUserService).hasMatchUser("tom", "1234");
		verify(mockUserService).registerUser(u);

	}

	//模拟实现类的测试
	@Test
	public void testMockClass() {
		//设定返回值
		when(mockServiceImpl.findUserByUserName("tom")).thenReturn(new User("tom", "1234"));
		doReturn(true).when(mockServiceImpl).hasMatchUser("tom", "1234");

		User user = mockServiceImpl.findUserByUserName("tom");
		boolean isMatch = mockServiceImpl.hasMatchUser("tom","1234");
		assertNotNull(user);
		assertEquals(user.getUserName(), "tom");
		assertEquals(isMatch, true);
		//验证
		verify(mockServiceImpl).findUserByUserName("tom");
		verify(mockServiceImpl).hasMatchUser("tom", "1234");
	}

	//模拟对象的测试
	@Test
	public void testMockUser() {
		//初始化并设定返回值
		MockitoAnnotations.initMocks(mockUser);
		when(mockUser.getUserId()).thenReturn(1);
		when(mockUser.getUserName()).thenReturn("tom");
		assertEquals(mockUser.getUserId(),1);
		assertEquals(mockUser.getUserName(), "tom");
	}

}
