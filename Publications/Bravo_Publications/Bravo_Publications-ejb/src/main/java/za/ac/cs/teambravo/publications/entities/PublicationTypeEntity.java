package za.ac.cs.teambravo.publications.entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;

/**
 *
 * @author Hlengekile
 */
@Entity
@NamedQueries({
    //@NamedQuery(name = "Lifecyclestate.findAll", query = "SELECT l FROM Lifecyclestate l"),
    @NamedQuery(name = "PublicationType.findBytypeName", query = "SELECT l FROM PublicationType l WHERE l.typeName = :type")
    //@NamedQuery(name = "Lifecyclestate.findByState", query = "SELECT l FROM Lifecyclestate l WHERE l.state = :state"),
    //@NamedQuery(name = "Lifecyclestate.findByPercentagecompleted", query = "SELECT l FROM Lifecyclestate l WHERE l.percentagecompleted = :percentagecompleted"),
    //@NamedQuery(name = "Lifecyclestate.findByPublicationdate", query = "SELECT l FROM Lifecyclestate l WHERE l.publicationdate = :publicationdate"),
    //@NamedQuery(name = "Lifecyclestate.findByBibtexentry", query = "SELECT l FROM Lifecyclestate l WHERE l.bibtexentry = :bibtexentry")
})
public class PublicationTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeID;
    
    @Column
    private String typeName;
    
    @OneToMany(targetEntity = PublicationTypeStateEntity.class)
    private List<PublicationTypeStateEntity> typeStates;
    
    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }
    
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<PublicationTypeStateEntity> getTypeStates() {
        return typeStates;
    }

    public void setTypeStates(List<PublicationTypeStateEntity> typeStates) {
        this.typeStates = typeStates;
    }
    
    public void addStateEntry(PublicationTypeStateEntity state)
    {
        typeStates.add(state);
    }

    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeID != null ? typeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationTypeEntity)) {
            return false;
        }
        PublicationTypeEntity other = (PublicationTypeEntity) object;
        if ((this.typeID == null && other.typeID != null) || (this.typeID != null && !this.typeID.equals(other.typeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.cs.teambravo.publications.entities.PublicationTypes[ id=" + typeID + " ]";
    }
    
}
