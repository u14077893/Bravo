
package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Publications implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer publicationID;
    
    @ManyToOne
    private PublicationDetails details;
    
    @ManyToOne
    private LifeCycleState state;
  
    @ManyToOne
    private PublicationTargets target;
    
    @ManyToOne
    private PublicationType type; 

    public Publications() {
        super();
    }

    public Publications(Integer pubID) {
        super();
        this.publicationID = publicationID;
    }

    public Integer getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(Integer publicationID) {
        this.publicationID = publicationID;
    }

    public PublicationDetails getDetails() {
        return details;
    }

    public void setDetails(PublicationDetails details) {
        this.details = details;
    }

    public LifeCycleState getState() {
        return state;
    }

    public void setState(LifeCycleState state) {
        this.state = state;
    }

    public PublicationTargets getTarget() {
        return target;
    }

    public void setTarget(PublicationTargets target) {
        this.target = target;
    }

    public PublicationType getType() {
        return type;
    }

    public void setType(PublicationType type) {
        this.type = type;
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
        if (!(object instanceof Publications)) {
            return false;
        }
        Publications other = (Publications) object;
        if ((this.publicationID == null && other.publicationID != null) || (this.publicationID != null && !this.publicationID.equals(other.publicationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.Publications[ id=" + publicationID + " ]";
    }
    
}
