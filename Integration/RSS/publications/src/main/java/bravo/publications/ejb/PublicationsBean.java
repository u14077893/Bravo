/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.ejb;

import bravo.publications.entity.PublicationEntity;
import java.util.List;
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

    public void createPublication(String title, String staffNumber) {
        PublicationEntity publication = new PublicationEntity(title, staffNumber);
        em.persist(publication);
    }
    
    public List<String> getPublications() {
        List<String> titles = (List<String>) em.createNamedQuery("getTitle").getResultList();
        return titles;
    }
}
