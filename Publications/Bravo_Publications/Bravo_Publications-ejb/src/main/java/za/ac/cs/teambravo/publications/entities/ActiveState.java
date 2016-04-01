
package za.ac.cs.teambravo.publications.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Active")
public class ActiveState extends PublicationTypeState {

    private double accreditationPoints;

    public ActiveState() {
        super();
    }

    public ActiveState(Integer activationID, Date dateEffective, double accreditationPoints) {
        super(activationID, dateEffective);
        this.accreditationPoints = accreditationPoints;
    }

    public double getAccreditationPoints() {
        return accreditationPoints;
    }

    public void setAccreditationPoints(double accreditationPoints) {
        this.accreditationPoints = accreditationPoints;
    }
    
    
}
