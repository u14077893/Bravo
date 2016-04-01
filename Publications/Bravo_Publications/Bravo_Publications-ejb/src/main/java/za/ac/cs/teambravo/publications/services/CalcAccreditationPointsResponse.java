
package za.ac.cs.teambravo.publications.services;

import za.ac.cs.teambravo.publications.Response;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsResponse implements Response 
{
    private double sumAccreditationPoints;

    public double getSumAccreditationPoints() 
    {
        return sumAccreditationPoints;
    }

    public void setSumAccreditationPoints(double sumAccreditationPoints) 
    {
        this.sumAccreditationPoints = sumAccreditationPoints;
    }
    
    
}
