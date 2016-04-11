package za.ac.cs.teambravo.publications.requestandresponses;

import java.util.Date;
import za.ac.cs.teambravo.publications.base.*;

/**
 *
 * @author Jedd
 */
public class ChangePublicationStateRequest implements PublicationRequest {
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
