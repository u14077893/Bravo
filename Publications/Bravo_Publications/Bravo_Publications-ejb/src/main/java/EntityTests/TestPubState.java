/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import za.ac.cs.teambravo.publications.entities.InProgress;
import za.ac.cs.teambravo.publications.entities.Person;
import za.ac.cs.teambravo.publications.entities.PublicationDetails;
import za.ac.cs.teambravo.publications.entities.PublicationState;
import za.ac.cs.teambravo.publications.entities.PublicationTarget;
import za.ac.cs.teambravo.publications.entities.PublicationType;

/**
 *
 * @author moses
 */
public class TestPubState 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        
        Person f=new Person();
        f.setFirstName("Joseph");
        f.setSurname("Surname");
        
        manager.persist(f);
        
        Person g = new Person();
        g.setFirstName("Moses");
        g.setSurname("Surname2");
       
        manager.persist(g);
        
        
        List<Person> authorList = new ArrayList();
        authorList.add(f);
        authorList.add(g);
        
        PublicationDetails details = new PublicationDetails();
        details.setTitle("ThePaper");
        Date today = new Date("2016/04/13");
        details.setEnvisagedPublicationDate(today);
        details.setAuthors(authorList);
      
        manager.persist(details);
        
        
        
        PublicationTarget target = new PublicationTarget();
        target.setName("SA Journal");
        target.setWebsite("www.cs.up.ac.za");
        
        manager.persist(target);
        
        
        InProgress prog = new InProgress();
        prog.setPercentageComplete(55);
        
        manager.persist(prog);
        
        //fetch existing pub type??
        //Query typeQuery = manager.createQuery("Select pubType from PublicationType pubType WHERE pubType.typeName = :book");
        String ng="";
        TypedQuery<PublicationType> query= manager.createNamedQuery("PublicationType.findBytypeName",PublicationType.class);
        query.setParameter("type", "book");     //name is what I am searching by, 'red meat' is the search
        List results=query.getResultList();
        
        PublicationType f1=(PublicationType) results.get(0);    
        //System.out.println(f1.getSurname());
        
        
        PublicationState pubState = new PublicationState();
        pubState.setDetails(details);
        pubState.setTarget(target);
        pubState.setState(prog);
        pubState.setType(f1);
        
        manager.persist(pubState);
        manager.getTransaction().commit();
        
    }
    
    
}
