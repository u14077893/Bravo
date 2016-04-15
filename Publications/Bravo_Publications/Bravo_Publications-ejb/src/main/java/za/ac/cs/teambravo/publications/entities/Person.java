package za.ac.cs.teambravo.publications.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Hlengekile
 */
@Entity
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    private Integer personID;
    
    private String firstName;
    
    private String surname;
    
    private String groupName;

    public Person() {
        super();
    }

    public Person(Integer personID, String firstName, String surname, String groupName) {
        super();
        this.personID = personID;
        this.firstName = firstName;
        this.surname = surname;
        this.groupName = groupName;
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personID == null && other.personID!= null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.Authors[ id=" + personID + " ]";
    }
    
}
