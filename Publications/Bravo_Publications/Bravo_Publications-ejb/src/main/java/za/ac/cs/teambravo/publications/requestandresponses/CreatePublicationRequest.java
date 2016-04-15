package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.PublicationState;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CreatePublicationRequest implements PublicationRequest{
 
     private PublicationState publicationState;

    public void setPublicationState(PublicationState publicationState) {
        this.publicationState = publicationState;
    }

    public PublicationState getPublicationState() {
        return publicationState;
    }
    
   public CreatePublicationRequest(PublicationState publicationState)
    {
        this.publicationState = publicationState;
    }
    
    
}
