package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class PublicationDetailsEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detailsID;
   
    private String title;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date envisagedPublicationDate;
    
    @OneToMany(targetEntity = PersonEntity.class)
    private List authors; //These IDS are keys to the persons table

    public PublicationDetailsEntity() {
        super();
    }

    public PublicationDetailsEntity(Integer detailsID, String title, ArrayList authors, Date envisagedPublicationDate) {
        this.detailsID = detailsID;
        this.title = title;
        this.authors = authors;
        this.envisagedPublicationDate = envisagedPublicationDate;
    }

    public Integer getDetailsID() {
        return detailsID;
    }

    public void setDetailsID(Integer detailsID) {
        this.detailsID = detailsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEnvisagedPublicationDate() {
        return envisagedPublicationDate;
    }

    public void setEnvisagedPublicationDate(Date envisagedPublicationDate) {
        this.envisagedPublicationDate = envisagedPublicationDate;
    }
    
    public List getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailsID != null ? detailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationDetailsEntity)) {
            return false;
        }
        PublicationDetailsEntity other = (PublicationDetailsEntity) object;
        if ((this.detailsID == null && other.detailsID != null) || (this.detailsID != null && !this.detailsID.equals(other.detailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.PublicationDetails[ id=" + detailsID + " ]";
    }
    
}
