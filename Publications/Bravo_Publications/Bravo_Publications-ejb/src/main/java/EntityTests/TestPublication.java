/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import za.ac.cs.teambravo.publications.entities.InProgressEntity;
import za.ac.cs.teambravo.publications.entities.PersonEntity;
import za.ac.cs.teambravo.publications.entities.PublicationDetailsEntity;
import za.ac.cs.teambravo.publications.entities.PublicationEntity;
import za.ac.cs.teambravo.publications.entities.PublicationStateEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTargetEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;

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
        
        PersonEntity f=new PersonEntity();
        f.setFirstName("Joseph");
        f.setSurname("Surname");
        
        manager.persist(f);
        
        PersonEntity g = new PersonEntity();
        g.setFirstName("Moses");
        g.setSurname("Surname2");
       
        manager.persist(g);
        
        
        List<PersonEntity> authorList = new ArrayList();
        authorList.add(f);
        authorList.add(g);
        
        PublicationDetailsEntity details = new PublicationDetailsEntity();
        details.setTitle("ThePaper");
        Date today = new Date("2016/04/13");
        details.setEnvisagedPublicationDate(today);
        details.setAuthors(authorList);
      
        manager.persist(details);
        
        
        
        PublicationTargetEntity target = new PublicationTargetEntity();
        target.setName("SA Journal");
        target.setWebsite("www.cs.up.ac.za");
        
        manager.persist(target);
        
        
        InProgressEntity prog = new InProgressEntity();
        prog.setPercentageComplete(55);
        
        manager.persist(prog);
        
        //fetch existing pub type??
        //Query typeQuery = manager.createQuery("Select pubType from PublicationType pubType WHERE pubType.typeName = :book");
        
        TypedQuery<PublicationTypeEntity> query= manager.createNamedQuery("PublicationType.findBytypeName",PublicationTypeEntity.class);
        query.setParameter("type", "book");  
        List results=query.getResultList();
        
        PublicationTypeEntity f1=(PublicationTypeEntity) results.get(0);    
        //System.out.println(f1.getSurname());
        
        
        PublicationStateEntity pubState = new PublicationStateEntity();
        pubState.setDetails(details);
        pubState.setTarget(target);
        pubState.setState(prog);
        pubState.setType(f1);
        
        manager.persist(pubState);
        
        
        PersonEntity f2=new PersonEntity();
        f2.setFirstName("Joseph");
        f2.setSurname("Surname");
        
        manager.persist(f2);
        
        PersonEntity g2 = new PersonEntity();
        g2.setFirstName("Moses");
        g2.setSurname("Surname2");
       
        manager.persist(g2);
        
        
        List<PersonEntity> authorList2 = new ArrayList();
        authorList2.add(f2);
        authorList2.add(g2);
        
        PublicationDetailsEntity details2 = new PublicationDetailsEntity();
        details2.setTitle("ThePaper");
        Date today2 = new Date("2016/04/13");
        details2.setEnvisagedPublicationDate(today2);
        details2.setAuthors(authorList2);
      
        manager.persist(details2);
        
        
        
        PublicationTargetEntity target2 = new PublicationTargetEntity();
        target2.setName("SA Journal");
        target2.setWebsite("www.cs.up.ac.za");
        
        manager.persist(target2);
        
        
        InProgressEntity prog2 = new InProgressEntity();
        prog2.setPercentageComplete(55);
        
        manager.persist(prog2);
        
        //fetch existing pub type??
        //Query typeQuery = manager.createQuery("Select pubType from PublicationType pubType WHERE pubType.typeName = :book");
        TypedQuery<PublicationTypeEntity> query2= manager.createNamedQuery("PublicationType.findBytypeName",PublicationTypeEntity.class);
        query2.setParameter("type", "book");     //name is what I am searching by, 'red meat' is the search
        List results2 =query2.getResultList();
        
        PublicationTypeEntity f12=(PublicationTypeEntity) results.get(0);    
        //System.out.println(f1.getSurname());
        
        
        PublicationStateEntity pubState2 = new PublicationStateEntity();
        pubState.setDetails(details2);
        pubState.setTarget(target2);
        pubState.setState(prog2);
        pubState.setType(f12);
        
        manager.persist(pubState2);
        
        Stack<PublicationStateEntity> stateList = new Stack();
        
        stateList.add(pubState);
        stateList.add(pubState2);
        
        
        PublicationEntity pub = new PublicationEntity();
        pub.setStateEntries(stateList);
        
        manager.persist(pub);
        manager.getTransaction().commit();
        
        
    }
    
}
