package za.ac.cs.teambravo.publications.base;

import Main.PublicationException;

public class PublicationWithTitleExistsForAuthors extends PublicationException
{

    public PublicationWithTitleExistsForAuthors()
    {
    }

    public PublicationWithTitleExistsForAuthors(String message) 
    {
        super(message);
    }

    public PublicationWithTitleExistsForAuthors(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public PublicationWithTitleExistsForAuthors(Throwable cause) 
    {
        super(cause);
    }
  
}
