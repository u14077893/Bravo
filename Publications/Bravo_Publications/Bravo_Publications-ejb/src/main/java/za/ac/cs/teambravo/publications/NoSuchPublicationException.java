
package za.ac.cs.teambravo.publications;

/**
 *
 * @author Hlengekile
 */
public class NoSuchPublicationException extends PublicationException
{

    public NoSuchPublicationException() 
    {
    }

    public NoSuchPublicationException(String message) 
    {
        super(message);
    }

    public NoSuchPublicationException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public NoSuchPublicationException(Throwable cause) 
    {
        super(cause);
    }
    
}
