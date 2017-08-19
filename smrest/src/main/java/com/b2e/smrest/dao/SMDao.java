package com.b2e.smrest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.b2e.smrest.util.AppConstants;

@Component
public class SMDao {

	private Connection connection;

	static Logger log = LogManager.getLogger(SMDao.class.getName());

	public SMDao() {

	}

}
