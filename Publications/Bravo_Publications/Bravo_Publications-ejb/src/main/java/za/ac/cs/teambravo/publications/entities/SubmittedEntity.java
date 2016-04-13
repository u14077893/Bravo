package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Submitted")
public class SubmittedEntity extends LifeCycleStateEntity {

    public SubmittedEntity() {
        super();
    }

}

