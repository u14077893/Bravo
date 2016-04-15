/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.ac.cs.teambravo.publications.entities.AbandonedEntity;
import za.ac.cs.teambravo.publications.entities.InProgressEntity;
import za.ac.cs.teambravo.publications.entities.InRevisionEntity;
import za.ac.cs.teambravo.publications.entities.PublishedEntity;
import za.ac.cs.teambravo.publications.entities.SubmittedEntity;

/**
 *
 * @author moses
 */
public class TestLifeCycleState 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        
        //To add a row
        //LifeCycleState a = new LifeCycleState();
        
        InProgressEntity f=new InProgressEntity();
        f.setPercentageComplete(55);
        AbandonedEntity g = new AbandonedEntity(); 
        SubmittedEntity h = new SubmittedEntity();
        InProgressEntity k = new InProgressEntity();
        k.setPercentageComplete(40);
        PublishedEntity p = new PublishedEntity();
        p.setPublicationDate(new Date("2016/04/29"));
        InRevisionEntity r = new InRevisionEntity();
        
        
        //f.setFirstNames("Sam");
        //f.setSurname("Sommy");
        
        manager.getTransaction().begin();
        manager.persist(f);
        manager.persist(g);
        manager.persist(h);
        manager.persist(k);
        manager.persist(p);
        manager.persist(r);
        manager.getTransaction().commit();
        
        //To search by ID
        /*f=manager.find(PersonEntity.class,1);
        System.out.println(f.getFirstNames());
        */
    }
}
