package com.example.testframework.junit;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.testframework.dao.UserDao;
import com.example.testframework.domain.User;

//@RunWith(SpringJUnit4ClassRunner.class)SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml") 多个配置文件
//的话可以用数组表示{"applicationContext.xml"，"applicationContext1.xml"}，下面我会贴我的配置文件，只有一个配置文件
@ContextConfiguration("classpath:spring-context.xml")
//@ActiveProfiles(value="dev")配置环境选择
@ActiveProfiles(value="dev")
//@Transactional这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)这里的事务关联到配
//置文件中的事务控制器（transactionManager = "transactionManager"），同时指定自动回滚（defaultRollback = true）。
//这样做操作的数据才不会污染数据库！ 
@Transactional
public class UserTest {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private UserDao userDao;
    
    @Test
    public void testUserInsert() {
        User user=new User();
        user.setUserName("lisa");
        user.setPassword("222222");
        user.setLastVisit(new Date());
        userDao.save(user);
        logger.info("--------->testUserInsert end-------------");
    }

    @Test
    public void testUserSelect() {
        User user = userDao.findUserByUserName(null);
        logger.info("--------->"+user.getUserName()+"-------------");
        logger.info("--------->testUserInsert end-------------");
    }
	
}
