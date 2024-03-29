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
    private PersonMock person;
     private ArrayList<PersonMock> authors;

    
    public void setAuthors(ArrayList<PersonMock> authors) {
        this.authors = authors;
    }
    
    public ArrayList<PersonMock> getAuthors()
    {
        return authors;
    }

    public PublicationDetails(String pubTitle, Date envisagedPublicationDate, PersonMock person) {
        this.pubTitle = pubTitle;
        this.envisagedPublicationDate = envisagedPublicationDate;
        this.person = person;
    }

    public PersonMock getPerson() {
        return person;
    }

    public void setPerson(PersonMock person) {
        this.person = person;
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
