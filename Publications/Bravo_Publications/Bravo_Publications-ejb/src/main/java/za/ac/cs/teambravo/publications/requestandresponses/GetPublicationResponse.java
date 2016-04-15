package za.ac.cs.teambravo.publications.requestandresponses;

import javax.persistence.Entity;
import za.ac.cs.teambravo.publications.entities.PublicationEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class GetPublicationResponse implements PublicationResponse
{
    public PublicationEntity publicationObject;

    public GetPublicationResponse(PublicationEntity publicationObject) {
        this.publicationObject = publicationObject;
    }

    public PublicationEntity getPublicationObject() {
        return publicationObject;
    }

    public void setPublicationObject(PublicationEntity publicationObject) {
        this.publicationObject = publicationObject;
    }
}
