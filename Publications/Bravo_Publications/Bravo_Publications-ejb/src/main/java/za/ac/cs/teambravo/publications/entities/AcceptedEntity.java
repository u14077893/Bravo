package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Accepted")
public class AcceptedEntity extends LifeCycleStateEntity {

    public AcceptedEntity() 
    {
        super();
    }

   
    
}

