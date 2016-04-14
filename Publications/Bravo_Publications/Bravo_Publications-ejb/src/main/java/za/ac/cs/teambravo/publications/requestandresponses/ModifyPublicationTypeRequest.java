package za.ac.cs.teambravo.publications.requestandresponses;
import za.ac.cs.teambravo.publications.base.*;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ModifyPublicationTypeRequest implements PublicationRequest{
    private PublicationType publicationTypeObject;
    private PublicationTypeState publicationTypeStateObject;
    
    public ModifyPublicationTypeRequest(String publicationTypeName, Date effectiveDate){
        publicationTypeObject.setPublicationType(publicationTypeName);
        publicationTypeStateObject.setEffectiveDate(effectiveDate);
    }

    public PublicationType getPublicationTypeObject() {
        return this.publicationTypeObject;

    }

    public PublicationTypeState getPublicationTypeStateObject() {
      return this.publicationTypeStateObject;
    }

}
