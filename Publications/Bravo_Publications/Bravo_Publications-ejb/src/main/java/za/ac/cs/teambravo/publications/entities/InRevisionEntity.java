package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="InRevision")
public class InRevisionEntity extends LifeCycleStateEntity {

    public InRevisionEntity() {
        super();
    }
    
}

