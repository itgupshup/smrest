package com.b2e.smrest.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2e.smrest.dao.LoginDao;
import com.b2e.smrest.dao.MessageDao;

@RestController
public class SMParentController {

	@Autowired
	private MessageDao smDAO;

	static Logger log = LogManager.getLogger(SMParentController.class.getName());

	@RequestMapping("/smparent")
	public String welcome1() {// Welcome page, non-rest
		LoginDao loginDao = new LoginDao();
		loginDao.authenticate();
		return "Welcome to RestTemplate Example.";
	}



}