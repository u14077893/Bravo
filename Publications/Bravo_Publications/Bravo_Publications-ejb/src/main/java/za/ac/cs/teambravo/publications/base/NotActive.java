package za.ac.cs.teambravo.publications.base;

import java.util.Date;



public class NotActive extends PublicationTypeState
{

    public NotActive() {
        super();
    }
    

    public NotActive(Date effectiveDate, String deactivationReason) {
        super(effectiveDate);
        this.deactivationReason = deactivationReason;
    }
    public String getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(String deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

	private String deactivationReason;

}