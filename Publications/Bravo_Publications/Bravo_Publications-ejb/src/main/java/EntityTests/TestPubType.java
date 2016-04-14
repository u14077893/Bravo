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
import za.ac.cs.teambravo.publications.entities.ActiveState;
import za.ac.cs.teambravo.publications.entities.NotActiveState;
import za.ac.cs.teambravo.publications.entities.PublicationType;
import za.ac.cs.teambravo.publications.entities.PublicationTypeState;

/**
 *
 * @author moses
 */
public class TestPubType 
{
    public static void main(String[] args) 
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
        
        ActiveState as = new ActiveState();
        
        as.setDateEffective(new Date("2016/04/12"));
        as.setAccreditationPoints(5.5);
        
        NotActiveState na = new NotActiveState();
        na.setDateEffective(new Date("2016/04/12"));
        na.setDeactivationReason("don't like it");
        
        manager.getTransaction().begin();
        manager.persist(as);
        manager.persist(na);
        manager.getTransaction().commit();
        
        List<PublicationTypeState> typeStates = new ArrayList();
        typeStates.add(as);
        typeStates.add(na);
       
        
        PublicationType type = new PublicationType();
        
        type.setTypeName("book");
        type.setTypeStates(typeStates);
        manager.getTransaction().begin();
        manager.persist(type);
        manager.getTransaction().commit();
        

       
    }
}
