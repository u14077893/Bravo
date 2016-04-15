/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author moses
 */
@Entity
public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publicationID;
    Stack<PublicationState> publicationStateObject;

    public Stack<PublicationState> getPublicationStateObject() {
        return publicationStateObject;
    }

    public void setPublicationStateObject(Stack<PublicationState> publicationStateObject) {
        this.publicationStateObject = publicationStateObject;
    }
    
    
    @OneToMany(targetEntity = PublicationState.class)
    private List stateEntries;

    public Integer getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(Integer publicationID) {
        this.publicationID = publicationID;
    }
    
    public List getStateEntries() {
        return stateEntries;
    }

    public void setStateEntries(List stateEntries) {
        this.stateEntries = stateEntries;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationID != null ? publicationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.publicationID == null && other.publicationID != null) || (this.publicationID != null && !this.publicationID.equals(other.publicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Publication[ id=" + publicationID + " ]";
    }

    public void addStateEntry(PublicationState newState) {
        this.publicationStateObject.add(newState);
    }
    
}
