
package za.ac.cs.teambravo.publications;

/**
 *
 * @author Hlengekile
 */
public class AlreadyPublishedException extends PublicationException
{

    public AlreadyPublishedException() 
    {
    }

    public AlreadyPublishedException(String message) 
    {
        super(message);
    }

    public AlreadyPublishedException(String message, Throwable cause) 
    {
        super(message, cause);
    }

    public AlreadyPublishedException(Throwable cause)
    {
        super(cause);
    }
    
}
