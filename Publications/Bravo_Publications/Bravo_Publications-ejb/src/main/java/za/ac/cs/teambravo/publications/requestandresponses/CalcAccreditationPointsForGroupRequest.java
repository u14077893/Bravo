/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsForGroupRequest implements PublicationRequest
{
    private String groupName;

    public CalcAccreditationPointsForGroupRequest(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
}
