/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.ac.cs.teambravo.publications.entities.PublicationTarget;

/**
 *
 * @author moses
 */
public class TestPubTarget 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();

        PublicationTarget target = new PublicationTarget();

        target.setName("SA Journal");
        target.setWebsite("www.cs.up.ac.za");

        manager.getTransaction().begin();
        manager.persist(target);
        manager.getTransaction().commit();
    }
    
}
