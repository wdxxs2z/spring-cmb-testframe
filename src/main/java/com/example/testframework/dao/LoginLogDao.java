package com.example.testframework.dao;

import org.springframework.stereotype.Repository;

import com.example.testframework.domain.LoginLog;
@Repository
public interface LoginLogDao {
   void insertLoginLog(LoginLog loginLog);
}