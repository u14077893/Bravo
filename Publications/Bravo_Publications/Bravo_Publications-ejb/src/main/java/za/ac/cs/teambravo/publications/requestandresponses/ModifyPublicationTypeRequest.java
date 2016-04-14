package za.ac.cs.teambravo.publications.requestandresponses;
import za.ac.cs.teambravo.publications.base.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ModifyPublicationTypeRequest implements PublicationRequest{
    private String name; //the name of the publication type that you want to modify
    private PublicationTypeState publicationTypeStateObject; //the publication type state with new effective date
    
    //constructor:
    public ModifyPublicationTypeRequest(String name, PublicationTypeState publicationTypeStateObject) {
        this.name = name;
        this.publicationTypeStateObject = publicationTypeStateObject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublicationTypeState getPublicationTypeStateObject() {
        return publicationTypeStateObject;
    }

    public void setPublicationTypeStateObject(PublicationTypeState publicationTypeStateObject) {
        this.publicationTypeStateObject = publicationTypeStateObject;
    }
    
    
}
