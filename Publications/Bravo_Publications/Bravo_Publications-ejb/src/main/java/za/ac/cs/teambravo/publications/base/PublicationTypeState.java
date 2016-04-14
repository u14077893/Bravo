package za.ac.cs.teambravo.publications.base;



import java.util.Date;

public class PublicationTypeState
{
    
    Date effectiveDate;

    public PublicationTypeState() {
    }

    public PublicationTypeState(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    
}