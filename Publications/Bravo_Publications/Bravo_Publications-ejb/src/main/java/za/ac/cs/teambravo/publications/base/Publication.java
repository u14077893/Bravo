package za.ac.cs.teambravo.publications.base;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kudzai
 */
public class Publication 
{
    ArrayList<PublicationState> publicationStateObject;

    public Publication() {
        this.publicationStateObject = new ArrayList();
    }

    public ArrayList<PublicationState> getPublicationStateObject() {
        return publicationStateObject;
    }

    public void setPublicationStateObject(ArrayList<PublicationState> publicationStateObject) {
        this.publicationStateObject = publicationStateObject;
    }
            
    public void addStateEntry(PublicationState stateEntry)
    {
        publicationStateObject.add(stateEntry);
    }
}
