/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.ejb;

import bravo.publications.entity.PublicationEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dillon
 */
@Stateless
public class PublicationsBean {
    private static final Logger logger = Logger.getLogger("main.ejb.PublicationBean");

    @PersistenceContext
    private EntityManager em;

    public void createPublication() {
        String title = "A Comprehensive Experiment on Jargon";
        String staffNumber = "14035538";
        PublicationEntity publication = new PublicationEntity(title, staffNumber);

        em.persist(publication);
    }
    
    public String getPublication() {
        String title = (String) em.createNamedQuery("getTitle").getSingleResult();
        return title;
    }
}
