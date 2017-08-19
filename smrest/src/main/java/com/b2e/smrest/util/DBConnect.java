package com.b2e.smrest.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnect {

	
	private DataSource dataSource;
	private Connection connection;

	static Logger log = LogManager.getLogger(DBConnect.class.getName());
	
	public DBConnect(){
		
	}
	
	public void connect() {
		try {
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup(AppConstants.DATA_SOURCE);

			if (dataSource == null) {
				log.error("Unable to fetch SMRest data source !!!");

			} else {
				// get database connection
				connection = dataSource.getConnection();

				if (connection == null) {
					log.error("Unable to connect to SMRest database !!!");
				} else {
					log.debug("SMRest Data Source connected !!!");
				}
			}

		} catch (NamingException nme) {
			log.error("NamingException --- " + nme);
			nme.printStackTrace();
		} catch (SQLException sqe) {
			log.error("SQLException --- " + sqe);
			sqe.printStackTrace();
		}
	}

	public Connection getConnection() {
		if (connection != null) {
			return connection;
		} else {
			return null;
		}
	}

	public void closeConnection() {
		try {
			connection.close();
			connection = null;
			log.debug("SMRest Data Source disconnected !!!");
		} catch (SQLException sqlException) {
			log.error("SQLException --- " + sqlException);
			sqlException.printStackTrace();
		}
	}
	

}
