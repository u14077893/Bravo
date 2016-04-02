import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ejb.PersonBean;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("reporting");
		EntityManager em = emf.createEntityManager();
		
		PersonBean pb = new PersonBean();
		//entity.Person p = em.find(entity.Person.class, 1);
		
		entity.Person p = pb.getPersonByID(1);
		System.out.println(p.getFirstNames());
	}
}
