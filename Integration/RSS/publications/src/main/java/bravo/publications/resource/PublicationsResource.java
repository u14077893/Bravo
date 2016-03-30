/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.publications.resource;

import bravo.publications.ejb.PublicationsBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;


/**
 *
 * @author Dillon
 */
@Path("publications")
public class PublicationsResource {
    @EJB
    private PublicationsBean publicationsBean;
    
    @GET
    @Path("createPublication")
    public void createPublication() {
        publicationsBean.createPublication();
    }
    
    @GET
    @Produces("text/plain")
    @Path("getPublication")
    public String getPublication() {
        return publicationsBean.getPublication();
    }
}
