package com.github.edveloso.spring.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.edveloso.spring.database.IPersonDAO;
import com.github.edveloso.spring.database.domain.Person;

@Controller
public class PersonControler {
	
	@Autowired
	private IPersonDAO personDAO;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public String addPerson(
    		@RequestParam("firstName") String firstName, 
    		@RequestParam("lastName") String lastName, 
    		Model model) {		
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		
		logger.debug("Is dao autowired? " + person != null);
		personDAO.addPerson(person);
		
		
		model.addAttribute("persons", personDAO.list());
		model.addAttribute("result", "Person added");
		return "index.jsp";
	}

}
