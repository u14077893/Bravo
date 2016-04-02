package ejb;

import javax.ejb.Stateless;
import javax.persistence.*;
import entity.*;

@Stateless
public class PersonBean {
	//Pass persistence unit to entity manager
	@PersistenceContext(unitName = "reporting")
	private EntityManager entityManager;
	
	public void addPerson(Person p) {
		entityManager.persist(p);
	}
	
	public Person getPersonByID(int id) {
		return entityManager.find(Person.class, id);
	}
}
