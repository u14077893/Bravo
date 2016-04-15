package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.PublicationType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AddPublicationTypeRequest implements PublicationRequest{
     PublicationType publicationTypeObject;
 

   

    public AddPublicationTypeRequest(PublicationType publicationTypeObject) {
        this.publicationTypeObject = publicationTypeObject;
    }


    public PublicationType getPublicationTypeObject() {
        return publicationTypeObject;
    }

    public void setPublicationTypeObject(PublicationType publicationTypeObject) {
        this.publicationTypeObject = publicationTypeObject;
    }
}
