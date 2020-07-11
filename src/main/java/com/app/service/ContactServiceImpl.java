package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.ContactEntity;
import com.app.model.Contact;
import com.app.repo.ContactDetailsRepository;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDetailsRepository repo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity savedEntity=repo.save(entity);
		
		return savedEntity.getContactId()!=null; 
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entities=repo.findAll();
		List<Contact> contacts=new ArrayList<>();
		for(ContactEntity con:entities)
		{
			Contact contact=new Contact();
			BeanUtils.copyProperties(con, contact);
			contacts.add(contact);
			
		}
		return contacts;
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<ContactEntity> findById=repo.findById(id);
		if(findById!=null){
			ContactEntity entity=findById.get();
			Contact c=new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
			
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		repo.deleteById(cid);
		
	
		return true;
	}

}
