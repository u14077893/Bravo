package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name="StateType" )
public class LifeCycleStateEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateID;

    public LifeCycleStateEntity() 
    {
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateID != null ? stateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LifeCycleStateEntity)) {
            return false;
        }
        LifeCycleStateEntity other = (LifeCycleStateEntity) object;
        if ((this.stateID == null && other.stateID != null) || (this.stateID != null && !this.stateID.equals(other.stateID))) {
            return false;
        }
        return true;
    }

    /*@Override
    public String toString() {
<<<<<<< HEAD:Publications/Bravo_Publications/Bravo_Publications-ejb/src/main/java/za/ac/cs/teambravo/publications/entities/LifeCycleStateEntity.java
        return "za.ac.cs.teambravo.publications.entities.LifeCycleStateEntity[ id=" + stateID + " ]";
    }*/
=======
        return "za.ac.cs.teambravo.publications.entities.LifeCycleState[ id=" + stateID + " ]";
    }

    public Object getStateString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
>>>>>>> origin/master:Publications/Bravo_Publications/Bravo_Publications-ejb/src/main/java/za/ac/cs/teambravo/publications/entities/LifeCycleState.java
    
}
