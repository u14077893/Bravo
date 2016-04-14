package za.ac.cs.teambravo.publications.entities;



//package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table
public class PublicationStateEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publicationID;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    @Column
    private String reason;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    @OneToOne
    private PublicationDetailsEntity details;
    
    @OneToOne
    private LifeCycleStateEntity state;
  
    @OneToOne
    private PublicationTargetEntity target;
    
    @ManyToOne
    private PublicationTypeEntity type; 

    public PublicationStateEntity() {
        super();
    }

    public PublicationStateEntity(Integer publicationID, PublicationDetailsEntity details, LifeCycleStateEntity state, PublicationTargetEntity target, PublicationTypeEntity type) {
        super();
        this.publicationID = publicationID;
        this.details = details;
        this.state = state;
        this.target = target;
        this.type = type;
    }
    
    public Integer getPublicationID() {
        return publicationID;
    }

    public void setPublicationID(Integer publicationID) {
        this.publicationID = publicationID;
    }

    public PublicationDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(PublicationDetailsEntity details) {
        this.details = details;
    }

    public LifeCycleStateEntity getState() {
        return state;
    }

    public void setState(LifeCycleStateEntity state) {
        this.state = state;
    }

    public PublicationTargetEntity getTarget() {
        return target;
    }

    public void setTarget(PublicationTargetEntity target) {
        this.target = target;
    }

    public PublicationTypeEntity getType() {
        return type;
    }

    public void setType(PublicationTypeEntity type) {
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
        if (!(object instanceof PublicationStateEntity)) {
            return false;
        }
        PublicationStateEntity other = (PublicationStateEntity) object;
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
