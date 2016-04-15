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
import za.ac.cs.teambravo.publications.entities.Person;
import za.ac.cs.teambravo.publications.entities.PublicationDetails;

/**
 *
 * @author moses
 */
public class TestDetails 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        Person f=new Person();
        f.setFirstName("Joseph");
        f.setSurname("Surname");
        
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        
        Person g = new Person();
        g.setFirstName("Moses");
        g.setSurname("Surname2");
        
        manager.getTransaction().begin();
        manager.persist(g);
        manager.getTransaction().commit();
        
        List<Person> authorList = new ArrayList();
        authorList.add(f);
        authorList.add(g);
        
        PublicationDetails details = new PublicationDetails();
        details.setTitle("ThePaper");
        Date today = new Date("2016/04/13");
        details.setEnvisagedPublicationDate(today);
        details.setAuthors(authorList);
        
        manager.getTransaction().begin();
        manager.persist(details);
        manager.getTransaction().commit();
        
   
        
        
        /*
        //To add a row
        PersonEntity f=new PersonEntity();
        f.setFirstName("Joseph");
        f.setSurname("Surname");
        
        manager.getTransaction().begin();
        manager.persist(f);
        manager.getTransaction().commit();
        
        //To search by ID
        f=manager.find(PersonEntity.class,2);
        System.out.println(f.getFirstName());
        System.out.println(f.getSurname());
        System.out.println("id:"+f.getPersonID());*/
        
    }
}
