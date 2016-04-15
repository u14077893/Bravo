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
public class CreatePublicationResponse implements PublicationResponse{
      PublicationState newPublicationState;

    public void setNewPublicationState(PublicationState newPublicationState) {
        this.newPublicationState = newPublicationState;
    }

    public PublicationState getNewPublicationState() {
        return newPublicationState;
    }

    public CreatePublicationResponse(PublicationState newPublicationState) {
        this.newPublicationState = newPublicationState;
    }

   
    
}
