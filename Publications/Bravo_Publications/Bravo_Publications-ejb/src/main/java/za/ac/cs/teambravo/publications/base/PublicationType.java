/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.base;

import java.util.List;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;

/**
 *
 * @author Kudzai
 */
public class PublicationType {
    String typeName;
    PublicationTypeState typeState;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public PublicationTypeState getTypeState() {
        return typeState;
    }

    public void setTypeStates(PublicationTypeState typeState) {
        this.typeState = typeState;
    }

    public PublicationType(String typeName, PublicationTypeState typeStates) {
        this.typeName = typeName;
        this.typeState = typeStates;
    }

 

  
    public void addStateEntry()
    {
        
    }
}
