package za.ac.cs.teambravo.publications.requestandresponses;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;
import za.ac.cs.teambravo.publications.base.LifeCycleState;
import za.ac.cs.teambravo.publications.base.PublicationDetails;
import za.ac.cs.teambravo.publications.base.PublicationState;
import za.ac.cs.teambravo.publications.base.PublicationTarget;
import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.exceptions.InvalidRequest;


/**
 *
 * @author User
 */
public class ChangePublicationStateRequest implements PublicationRequest {

    // A Publication?
    private PublicationState changeState;
    private String publicationTitle;
    private Boolean authorized;

    public ChangePublicationStateRequest(String title,Date date, String reason, PublicationDetails publicationDetailsObject, LifeCycleState lifeCycleStateObject, PublicationType publicationTypeObject, PublicationTarget publicationTargetObject) throws InvalidRequest {
        this.changeState = new PublicationState(date, reason, publicationDetailsObject, lifeCycleStateObject, publicationTypeObject, publicationTargetObject);
        this.publicationTitle=title;
        authorized=false;
        if(title.equals("") || date==null||reason.equals("")|| publicationDetailsObject==null || lifeCycleStateObject==null||publicationTypeObject==null||publicationTargetObject==null)
        {
            throw(new InvalidRequest());
        }
    }

    public Boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public String getPublicationTitle() {
        return publicationTitle;
    }

    public void setPublicationTitle(String publicationTitle) {
        this.publicationTitle = publicationTitle;
    }

    public PublicationState getChangeState() {
        return changeState;
    }
    
    
}
