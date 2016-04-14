package za.ac.cs.teambravo.publications.base;


//package za.ac.cs.teambravo.publications.publication_details;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hlengekile
 */
public class PublicationDetails
{
    private String pubTitle;
    private Date envisagedPublicationDate;
    private ArrayList<PersonMock> authors;

    public PublicationDetails(String pubTitle, Date envisagedPublicationDate, ArrayList<PersonMock> authors) {
        this.pubTitle = pubTitle;
        this.envisagedPublicationDate = envisagedPublicationDate;
        this.authors = authors;
    }

    public ArrayList<PersonMock> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<PersonMock> authors) {
        this.authors = authors;
    }

    
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
