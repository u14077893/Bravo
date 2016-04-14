package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Active")
public class ActiveStateEntity extends PublicationTypeStateEntity {

    private double accreditationPoints;

    public ActiveStateEntity() {
        super();
    }

    public double getAccreditationPoints() {
        return accreditationPoints;
    }

    public void setAccreditationPoints(double accreditationPoints) {
        this.accreditationPoints = accreditationPoints;
    }

  

    public ActiveStateEntity(double accreditationPoints, Integer activationID, Date dateEffective) {
        super(activationID, dateEffective);
        this.accreditationPoints = accreditationPoints;
    }
    
    
}
