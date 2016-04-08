/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications;

import za.ac.cs.teambravo.publications.Request;
import za.ac.cs.teambravo.publications.entities.Person;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsRequest implements Request
{
    private Person forWho;
    private String groupName;

    public CalcAccreditationPointsRequest(Person forWho) 
    {
        this.forWho  = forWho;
        this.groupName = null;
    }

    public CalcAccreditationPointsRequest(String groupName) 
    {
        this.groupName = groupName;
        this.forWho = null;
    }

    public Person getForWho() {
        return forWho;
    }

    public void setForWho(Person forWho) {
        this.forWho = forWho;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public boolean personRequest()
    {
        if(this.forWho == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public boolean groupRequest()
    {
        if(this.groupName == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
