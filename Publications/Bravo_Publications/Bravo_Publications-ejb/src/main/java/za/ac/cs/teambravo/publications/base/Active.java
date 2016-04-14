package za.ac.cs.teambravo.publications.base;

import java.util.Date;



public class Active extends PublicationTypeState
{
    private double accreditationPoints;

    public Active(double accreditationPoints) {
        super();
    }

    public Active(double accreditationPoints, Date effectiveDate) {
        super(effectiveDate);
        this.accreditationPoints = accreditationPoints;
    }
   
    public double getAccreditationPoints() {
        return accreditationPoints;
    }

    public void setAccreditationPoints(double accreditationPoints) {
        this.accreditationPoints = accreditationPoints;
    }
        
        

}