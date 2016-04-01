import javax.persistence.*;

public class PeopleEntityManagerBean {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("reporting");
	EntityManager entityManager = factory.createEntityManager();
	entity.Person p = entityManager.find(entity.Person.class, 1);
}
