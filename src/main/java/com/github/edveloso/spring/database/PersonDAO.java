package com.github.edveloso.spring.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.github.edveloso.spring.database.domain.Person;

public class PersonDAO implements IPersonDAO {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addPerson(Person person) {
		logger.debug(person.getFirstName() + " " + person.getLastName());
		System.out.println(person.getFirstName() + " " + person.getLastName());
		entityManager.persist(person);
		entityManager.flush();
	}	
	
	public List<Person> list(){
	  Query query = entityManager.createNamedQuery("listAll");
	  return query.getResultList();
	}
	
}
