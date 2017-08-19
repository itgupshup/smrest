package com.b2e.smrest.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.b2e.smrest.util.DBConnect;

public class LoginDao {
	
	private DataSource dataSource;
	private Connection connection;
	private DBConnect dbConnect = new DBConnect();

	static Logger log = LogManager.getLogger(LoginDao.class.getName());
	
	public LoginDao(){
		
	}
	
	public boolean authenticate(){
		boolean isAuthorized = false;
		return isAuthorized;
	}
	
	

}
