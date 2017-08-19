package com.b2e.smrest.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.b2e.smrest.domain.Message;

@Component
public class MessageDao {

	// Dummy database. Initialize with some dummy values.
	private static List <Message> messages;
	{
		messages = new ArrayList <Message>();
		messages.add(new Message(new Long(101), "Notice", "1st Semester starts on 1st Oct 2017"));
		messages.add(new Message(new Long(102), "Holiday", "26th July is Ramadan"));
		messages.add(new Message(new Long(103), "Homework", "Science, Maths and English"));
	}

	/**
	 * Returns list of Messages from dummy database.
	 * 
	 * @return list of Messages
	 */
	public List<Message> listMessages() {
		return messages;
	}

	/**
	 * Return Message object for given id from dummy database. If Message is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            Message id
	 * @return Message object for given id
	 */
	public Message get(Long id) {

		for (Message c : messages) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new Message in dummy database. Updates the id and insert new
	 * Message in list.
	 * 
	 * @param Message
	 *            Message object
	 * @return Message object with updated id
	 */
	public Message create(Message message) {
		messages.add(message);
		return message;
	}

	/**
	 * Delete the Message object from dummy database. If Message not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the Message id
	 * @return id of deleted Message object
	 */
	public Long delete(Long id) {

		for (Message c : messages) {
			if (c.getId().equals(id)) {
				messages.remove(c);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update the Message object for given id in dummy database. If Message
	 * not exists, returns null
	 * 
	 * @param id
	 * @param Message
	 * @return Message object with id
	 */
	public Message update(Long id, Message message) {

		for (Message c : messages) {
			if (c.getId().equals(id)) {
				message.setId(c.getId());
				messages.remove(c);
				messages.add(message);
				return message;
			}
		}

		return null;
	}

}