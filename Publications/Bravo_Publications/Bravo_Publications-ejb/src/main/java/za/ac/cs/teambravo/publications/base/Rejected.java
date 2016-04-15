package za.ac.cs.teambravo.publications.base;


//package za.ac.cs.teambravo.publications.publications;

public class Rejected{

   
    public LifeCycleState getState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public void setState(LifeCycleState newState) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   
    public String getStateString() {
        return "Rejected";
    }
    
}
