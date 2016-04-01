
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="InProgress")
public class InProgress extends LifeCycleState {
    
    private Integer percentageComplete;

    public InProgress() {
        super();
    }

    public InProgress(Integer percentageComplete, Integer stateID) {
        super(stateID);
        this.percentageComplete = percentageComplete;
    }

    public Integer getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(Integer percentageComplete) {
        this.percentageComplete = percentageComplete;
    }
   
    
}
