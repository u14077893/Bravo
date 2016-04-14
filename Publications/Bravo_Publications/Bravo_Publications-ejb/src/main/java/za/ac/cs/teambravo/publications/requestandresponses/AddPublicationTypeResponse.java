package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AddPublicationTypeResponse implements PublicationResponse{
     PublicationTypeEntity publicationTypeEntity = new PublicationTypeEntity();

    public AddPublicationTypeResponse() {
    }

    public PublicationTypeEntity getPublicationTypeEntity() {
        return publicationTypeEntity;
    }

    public void setPublicationTypeEntity(PublicationTypeEntity publicationTypeEntity) {
        this.publicationTypeEntity = publicationTypeEntity;
    }
}
