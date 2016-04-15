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
import za.ac.cs.teambravo.publications.entities.Abandoned;
import za.ac.cs.teambravo.publications.entities.InProgress;
import za.ac.cs.teambravo.publications.entities.InRevision;
import za.ac.cs.teambravo.publications.entities.Published;
import za.ac.cs.teambravo.publications.entities.Submitted;

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
        
        InProgress f=new InProgress();
        f.setPercentageComplete(55);
        Abandoned g = new Abandoned(); 
        Submitted h = new Submitted();
        InProgress k = new InProgress();
        k.setPercentageComplete(40);
        Published p = new Published();
        p.setPublicationDate(new Date("2016/04/29"));
        InRevision r = new InRevision();
        
        
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
