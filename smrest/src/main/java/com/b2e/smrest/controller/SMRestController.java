package com.b2e.smrest.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b2e.smrest.dao.LoginDao;
import com.b2e.smrest.dao.MessageDao;
import com.b2e.smrest.dao.SMDao;
import com.b2e.smrest.domain.Message;

@RestController
public class SMRestController {

	@Autowired
	private MessageDao smDAO;

	static Logger log = LogManager.getLogger(SMRestController.class.getName());

	@RequestMapping("/smrest")
	public String welcome() {// Welcome page, non-rest
		LoginDao loginDao = new LoginDao();
		loginDao.authenticate();
		return "Welcome to RestTemplate Example.";
	}

	@RequestMapping("/hello/{player}")
	public Message message(@PathVariable String player) {// REST Endpoint.

		Message msg = new Message(new Long(404), player, "Hello " + player);
		return msg;
	}

	@GetMapping("/gst")
	public List<Message> getMessages() {
		return smDAO.listMessages();
	}

	@GetMapping("/gst/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") Long id) {

		Message message = smDAO.get(id);
		if (message == null) {
			return new ResponseEntity("No Message found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(message, HttpStatus.OK);
	}

	@DeleteMapping("/gst/{id}")
	public ResponseEntity<Message> deleteMessage(@PathVariable Long id) {

		if (null == smDAO.delete(id)) {
			return new ResponseEntity("No Message found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/gst/{id}")
	public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {

		message = smDAO.update(id, message);

		if (null == message) {
			return new ResponseEntity("No Message found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(message, HttpStatus.OK);
	}

}