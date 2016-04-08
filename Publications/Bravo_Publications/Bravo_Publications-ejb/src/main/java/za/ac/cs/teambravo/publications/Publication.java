package za.ac.cs.teambravo.publications;

import za.ac.cs.teambravo.publications.entities.PublicationState;


public class Publication {
    PublicationState publicationStateObject;

    public PublicationState getPublicationStateObject() {
        return publicationStateObject;
    }

    public void setPublicationStateObject(PublicationState publicationStateObject) {
        this.publicationStateObject = publicationStateObject;
    }
            
    public void addStateEntry(PublicationState stateEntry)
    {
        
    }
}
