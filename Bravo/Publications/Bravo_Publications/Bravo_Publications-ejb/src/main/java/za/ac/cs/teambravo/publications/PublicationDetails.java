
package za.ac.cs.teambravo.publications;

import java.util.Date;

/**
 *
 * @author Hlengekile
 */
public class PublicationDetails
{
    private String pubTitle;
    private Date envisagedPublicationDate;
    
    public void setTitle(String inTitle)
    {
        pubTitle = inTitle;
    }
    
    public void setEnvisagedPublicationDate(Date inDate)
    {
        envisagedPublicationDate = inDate;
    }
    
    public String getTitle()
    {
        return pubTitle;
    }
    
    public Date getEnvisagedPublicationDate()
    {
        return envisagedPublicationDate;
    }
    
}
