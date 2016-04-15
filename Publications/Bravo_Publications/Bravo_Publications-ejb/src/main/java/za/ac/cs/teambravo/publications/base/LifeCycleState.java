package za.ac.cs.teambravo.publications.base;

import java.util.Date;



//package za.ac.cs.teambravo.publications.publications;

public class LifeCycleState {
    
 //   public LifeCycleState getState();
  //  public void setState(LifeCycleState newState);
   // public String getStateString();
    
    
    
   private String state;
   private Integer percentageCompleted;
   private Date publicationDate;
   private String bibTexEntry;

    public String getState() {
        return state;
    }
     public String getBibTexEntry() {
        return bibTexEntry;
    }

    public Integer getPercentageCompleted() {
        return percentageCompleted;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPercentageCompleted(Integer percentageCompleted) {
        this.percentageCompleted = percentageCompleted;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setBibTexEntry(String bibTexEntry) {
        this.bibTexEntry = bibTexEntry;
    }
    
    
    
}
