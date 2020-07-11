package com.app.service;

import java.util.List;

import com.app.entity.ContactEntity;
import com.app.model.Contact;

public interface ContactService {
	boolean saveContact(Contact c);
	List<Contact> getAllContacts();
	Contact getContactById(Integer id);
	boolean updateContact(Contact c);
	boolean deleteContact(Integer cid); 
	

}
