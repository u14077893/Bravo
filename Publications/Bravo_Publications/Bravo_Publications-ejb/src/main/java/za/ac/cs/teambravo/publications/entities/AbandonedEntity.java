package za.ac.cs.teambravo.publications.entities;


//package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Abandoned")
public class AbandonedEntity extends LifeCycleStateEntity {

    public AbandonedEntity() 
    {
        super();
    }

   
    
}

