/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Hlengekile
 */

@Entity
@DiscriminatorValue(value="Rejected")
public class RejectedEntity extends LifeCycleStateEntity 
{

    public RejectedEntity() 
    {
        super();
    }
 
}
