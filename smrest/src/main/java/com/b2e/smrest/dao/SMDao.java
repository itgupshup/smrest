package com.b2e.smrest.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.b2e.smrest.util.DBConnect;

@Component
public class SMDao {

	private DBConnect dbConnect = new DBConnect();

	static Logger log = LogManager.getLogger(SMDao.class.getName());

	public SMDao() {

	}

}
