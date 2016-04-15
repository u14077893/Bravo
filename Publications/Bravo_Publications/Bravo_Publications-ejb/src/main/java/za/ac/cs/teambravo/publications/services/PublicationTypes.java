package za.ac.cs.teambravo.publications.services;

import java.util.List;
import javax.ejb.Remote;
import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;

import za.ac.cs.teambravo.publications.exceptions.AuthorizationException;
import za.ac.cs.teambravo.publications.exceptions.PublicationTypeExistsException;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeResponse;

//package za.ac.cs.teambravo.publications.publications;
@Remote
public interface PublicationTypes 
{
    public PublicationType getPublicationType(PublicationType pubType);
     /**
     * Accepts a AddPublicationTypeRequest object to allow administrators to be able to add new publication types
     * @param addPublicationTypeRequest a request object passed to add a new PublicationType option
     * @return AddPublicationTypeResponse a response object that confirms PublicationType has been added
     * @see    PublicationType
     * @exception PublicationTypeExistsException the publication type is already an option
     * @exception  AuthorizationException user is not an administrator
     */
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest)throws AuthorizationException, PublicationTypeExistsException ;

    public PublicationType createPublicationType(PublicationType p);
    
   }