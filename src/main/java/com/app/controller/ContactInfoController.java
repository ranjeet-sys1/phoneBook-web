package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Contact;
import com.app.service.ContactService;

@Controller
public class ContactInfoController {
	@Autowired
	private ContactService contactService;
	@GetMapping(value= {"/","/addContact"})
	public String loadForm(Model model)
	{
		Contact c=new Contact();
		model.addAttribute("contact",c);
		return "contactInfo";
		
	}
	@PostMapping(value="/saveContact" )
	public String handleSubmitBtn(@ModelAttribute("contact")Contact c,Model model)
	{
		boolean isSaved=contactService.saveContact(c);
		if(isSaved)
		{
			model.addAttribute("succMsg","Contact Saved");
		}
		else {
			model.addAttribute("errMsg","Failed to save Contact");
		}
		return "contactInfo";
	}
	@GetMapping("/viewContacts")
	public String handleViewContactLink(Model model){
		List<Contact> contact=contactService.getAllContacts();
		model.addAttribute("contact",contact);
		return "viewContacts";
		
	}
	@RequestMapping("/editContact")
	public String editContact(@RequestParam("id")int id,Model model) {
		Contact contact=contactService.getContactById(id);
		model.addAttribute("contact",contact);
		
		return "contactInfo";
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("id")int id)
	{
		boolean isDelete=contactService.deleteContact(id);
		if(isDelete)
		{
			return "redirect:/viewContacts ";
		}
		return null;
	}
	

}
