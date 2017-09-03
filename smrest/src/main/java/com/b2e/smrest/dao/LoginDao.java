package com.b2e.smrest.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.b2e.smrest.util.DBConnect;

public class LoginDao {
	
	private DBConnect dbConnect = new DBConnect();

	static Logger log = LogManager.getLogger(LoginDao.class.getName());
	
	public LoginDao(){
		
	}
	
	public boolean authenticate(){
		boolean isAuthorized = false;
		
		dbConnect.connect();
		dbConnect.closeConnection();
		
		return isAuthorized;
	}
	
	

}
