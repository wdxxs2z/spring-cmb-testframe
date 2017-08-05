package com.example.testframework.junit;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.testframework.dao.UserDao;
import com.example.testframework.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class JdbcMockitoTest {
	
	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
    private UserDao userDao;
	
	@Before
    public void setUp() throws Exception {
        Mockito.when(jdbcTemplate.queryForObject(anyString(), Matchers.eq(String.class))).thenReturn("test");
    }
	
	@Test
    public void testQuery() {
		User user = userDao.findUserByUserName("test");

        assertEquals("test", user.getUserName());

        verify(jdbcTemplate).queryForObject(anyString(), eq(String.class));
    }

}
