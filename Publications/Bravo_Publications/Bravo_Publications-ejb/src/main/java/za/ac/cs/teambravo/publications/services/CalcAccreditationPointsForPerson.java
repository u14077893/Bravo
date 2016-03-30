
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
public class CalcAccreditationPointsForPerson implements CalcAccreditationPoints 
{
    private Person requester;
    private LinkedList<Publications> listOfPublished;

    public CalcAccreditationPointsForPerson() 
    {
    }

    public CalcAccreditationPointsForPerson(CalcAccreditationPointsRequest inRequest)
    {
        try
        {
            if(inRequest.personRequest())
            {
                this.requester = inRequest.getForWho();
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

    @Override
    public LinkedList<Publications> getPublishedPublications() 
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public double addPointsofPublished()
    {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public CalcAccreditationPointsResponse calculate() 
    {
        this.listOfPublished = getPublishedPublications();
        double points = addPointsofPublished();
        
        CalcAccreditationPointsResponse response = new CalcAccreditationPointsResponse();
        response.setSumAccreditationPoints(points);
        
        return response;  
    }
    
    
    
}
