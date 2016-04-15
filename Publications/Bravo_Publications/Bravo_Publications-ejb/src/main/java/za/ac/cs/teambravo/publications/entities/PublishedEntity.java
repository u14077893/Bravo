package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;

@Entity
@DiscriminatorValue(value="Published")
public class PublishedEntity extends LifeCycleStateEntity {
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationDate;
    private String bibTexReference;

    public PublishedEntity() {
        super();
    }
 
    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBibTexReference() {
        return bibTexReference;
    }

    public void setBibTexReference(String bibTexReference) {
        this.bibTexReference = bibTexReference;
    }
    
 
    
}
