
package za.ac.cs.teambravo.publications.services;

import java.util.LinkedList;

import za.ac.cs.teambravo.publications.entities.Publications;

/**
 *
 * @author Hlengekile
 */
public interface CalcAccreditationPoints 
{
    public LinkedList<Publications> getPublishedPublications();
    public double addPointsofPublished();
    public CalcAccreditationPointsResponse calculate();
}
