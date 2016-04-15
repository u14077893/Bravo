package za.ac.cs.teambravo.publications.base;

//package za.ac.cs.teambravo.publications.publications;


import java.util.Date;

public class Published{

    Date publicationDate;
    
    public LifeCycleState getState() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void setState(LifeCycleState newState) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public String getStateString() {
        return "Published";
    }
    
}
