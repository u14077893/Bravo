
package za.ac.cs.teambravo.publications.services;

import java.util.LinkedList;

import za.ac.cs.teambravo.publications.InvalidRequest;
import za.ac.cs.teambravo.publications.entities.Person;
import za.ac.cs.teambravo.publications.entities.Publications;
/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;*/

/**
 *
 * @author Hlengekile
 */

public class CalcAccreditationPointsForGroup implements CalcAccreditationPoints 
{
    private String requestingGroup;
    private LinkedList<Person> groupMembers;
    private LinkedList<Publications> listGroupPublished;

    public CalcAccreditationPointsForGroup() {
    }

    public CalcAccreditationPointsForGroup(CalcAccreditationPointsRequest inRequest)
    {
        try
        {
            if(inRequest.groupRequest())
            {
                this.requestingGroup = inRequest.getGroupName();
            }
            else
            {
                throw new InvalidRequest();
            }
        }
        catch(InvalidRequest e)
        {
        }
    }
 
    public LinkedList<Person> getGroupMembers()
    {
       throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public LinkedList<Publications> getPublishedPublications() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double addPointsofPublished() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CalcAccreditationPointsResponse calculate() 
    {
        this.groupMembers = getGroupMembers();
        this.listGroupPublished = getPublishedPublications();
        double points = addPointsofPublished();
        
        CalcAccreditationPointsResponse response = new CalcAccreditationPointsResponse();
        response.setSumAccreditationPoints(points);
        
        return response; 
    }
    
    
    
}
