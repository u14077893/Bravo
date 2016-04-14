package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.entities.PublicationType;

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
     PublicationType publicationTypeEntity = new PublicationType();

    public AddPublicationTypeResponse() {
    }

    public PublicationType getPublicationTypeEntity() {
        return publicationTypeEntity;
    }

    public void setPublicationTypeEntity(PublicationType publicationTypeEntity) {
        this.publicationTypeEntity = publicationTypeEntity;
    }
}
