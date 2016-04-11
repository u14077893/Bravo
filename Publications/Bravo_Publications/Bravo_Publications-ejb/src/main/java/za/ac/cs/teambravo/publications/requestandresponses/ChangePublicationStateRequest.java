package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.*;

/**
 *
 * @author Jedd
 */
public class ChangePublicationStateRequest implements PublicationRequest {
    private PublicationState changeState;
    private Publication publication;

    public ChangePublicationStateRequest(Integer publicationID, PublicationDetails details, LifeCycleState state, PublicationTarget target, PublicationType type,Publication publication) {
        this.changeState = new PublicationState(publicationID,details,state,target,type);
        this.publication=publication;
    }
    
    
    
    
    
}
