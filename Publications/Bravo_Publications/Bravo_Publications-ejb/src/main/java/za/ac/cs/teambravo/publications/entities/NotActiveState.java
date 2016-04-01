
package za.ac.cs.teambravo.publications.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="NotActive")
public class NotActiveState extends PublicationTypeState {
   
    @Column
    private String deactivationReason;

    public NotActiveState() {
        super();
    }

    public NotActiveState(Integer activationID, Date dateEffective, String deactivationReason) {
        super(activationID, dateEffective);
        this.deactivationReason = deactivationReason;
    }

    
    public String getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(String deactivationReason) {
        this.deactivationReason = deactivationReason;
    }
    
}
