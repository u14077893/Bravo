/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.ac.cs.teambravo.publications.entities.PersonEntity;

/**
 *
 * @author moses
 */
public class TestPerson 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        
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
        System.out.println("id:"+f.getPersonID());
        
    }
}
