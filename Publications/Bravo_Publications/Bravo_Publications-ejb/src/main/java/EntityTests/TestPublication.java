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
import za.ac.cs.teambravo.publications.entities.Publication;
import za.ac.cs.teambravo.publications.entities.PublicationState;
import za.ac.cs.teambravo.publications.entities.PublicationTarget;
import za.ac.cs.teambravo.publications.entities.PublicationType;

/**
 *
 * @author moses
 */
public class TestPublication
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
        
        
        Person f2=new Person();
        f2.setFirstName("Joseph");
        f2.setSurname("Surname");
        
        manager.persist(f2);
        
        Person g2 = new Person();
        g2.setFirstName("Moses");
        g2.setSurname("Surname2");
       
        manager.persist(g2);
        
        
        List<Person> authorList2 = new ArrayList();
        authorList2.add(f2);
        authorList2.add(g2);
        
        PublicationDetails details2 = new PublicationDetails();
        details2.setTitle("ThePaper");
        Date today2 = new Date("2016/04/13");
        details2.setEnvisagedPublicationDate(today2);
        details2.setAuthors(authorList2);
      
        manager.persist(details2);
        
        
        
        PublicationTarget target2 = new PublicationTarget();
        target2.setName("SA Journal");
        target2.setWebsite("www.cs.up.ac.za");
        
        manager.persist(target2);
        
        
        InProgress prog2 = new InProgress();
        prog2.setPercentageComplete(55);
        
        manager.persist(prog2);
        
        //fetch existing pub type??
        //Query typeQuery = manager.createQuery("Select pubType from PublicationType pubType WHERE pubType.typeName = :book");
        TypedQuery<PublicationType> query2= manager.createNamedQuery("PublicationType.findBytypeName",PublicationType.class);
        query2.setParameter("type", "book");     //name is what I am searching by, 'red meat' is the search
        List results2 =query2.getResultList();
        
        PublicationType f12=(PublicationType) results.get(0);    
        //System.out.println(f1.getSurname());
        
        
        PublicationState pubState2 = new PublicationState();
        pubState.setDetails(details2);
        pubState.setTarget(target2);
        pubState.setState(prog2);
        pubState.setType(f12);
        
        manager.persist(pubState2);
        
        List<PublicationState> stateList = new ArrayList();
        
        stateList.add(pubState);
        stateList.add(pubState2);
        
        
        Publication pub = new Publication();
        pub.setStateEntries(stateList);
        
        manager.persist(pub);
        manager.getTransaction().commit();
        
        
    }
    
}
