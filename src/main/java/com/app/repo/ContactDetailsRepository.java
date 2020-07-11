package com.app.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.ContactEntity;

public interface ContactDetailsRepository extends JpaRepository<ContactEntity,Serializable>  {
	

}
