package za.ac.cs.teambravo.publications;

public class Rejected implements LifeCycleState{

    @Override
    public LifeCycleState getState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setState(LifeCycleState newState) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public String getStateString() {
        return "Rejected";
    }
    
}