
package za.ac.cs.teambravo.publications.services;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import za.ac.cs.teambravo.publications.base.Publication;
import za.ac.cs.teambravo.publications.base.Period;
import za.ac.cs.teambravo.publications.base.PersonMock;
import za.ac.cs.teambravo.publications.base.PublicationConfidenceLevel;
import za.ac.cs.teambravo.publications.base.PublicationState;
import za.ac.cs.teambravo.publications.entities.PublicationEntity;
import za.ac.cs.teambravo.publications.entities.PublicationStateEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;
import za.ac.cs.teambravo.publications.exceptions.AlreadyPublishedException;
import za.ac.cs.teambravo.publications.exceptions.AuthorizationException;
import za.ac.cs.teambravo.publications.exceptions.EffectiveDateNotAfterEffectiveDateOfLastStateEntry;
import za.ac.cs.teambravo.publications.exceptions.InvalidRequest;
import za.ac.cs.teambravo.publications.exceptions.NoSuchPublicationException;
import za.ac.cs.teambravo.publications.exceptions.NotAuthorized;
import za.ac.cs.teambravo.publications.exceptions.PublicationWithTitleExistsForAuthors;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.AddPublicationTypeResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CalcAccreditationPointsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ChangePublicationStateResponse;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.CreatePublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForGroupResponse;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationsForPersonResponse;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ModifyPublicationTypeResponse;

/**
 *
 * @author Jedd, Hlengi, Moses, Gift, Kudzai, Vuyani
 */
@Stateless
public class PublicationsBean implements Publications 
{
    @Override
    public AddPublicationResponse addPublication(AddPublicationRequest addPublicationRequest) throws NotAuthorized {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) throws PublicationWithTitleExistsForAuthors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CreatePublicationResponse createPublication(CreatePublicationRequest createPublicationRequest) throws InvalidRequest {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void addPublicationState(Publication publication,PublicationState newState)
    {
      
        publication.addStateEntry(newState);
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(publication);
       entityManager.getTransaction().commit();
      
    }

    @Override
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) throws AuthorizationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest) throws AuthorizationException, EffectiveDateNotAfterEffectiveDateOfLastStateEntry {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GetPublicationsForPersonResponse getPublicationsForPerson(GetPublicationsForPersonRequest getPublicationsForPersonRequest) 
    {
        GetPublicationsForPersonResponse response = null;
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
                
        try
        {
            //Validate Request
            if(getPublicationsForPersonRequest == null || getPublicationsForPersonRequest.getRequester() == null || getPublicationsForPersonRequest.getPubConfidence() == null)
            {
               throw new InvalidRequest(); 
            }
            else
            {
                PersonMock requester = getPublicationsForPersonRequest.getRequester();
                String personName = requester.getFirstName();
                
                //Find person in database and get their associated publications
                ArrayList<PublicationEntity> personsPublications = null;
                
                PublicationConfidenceLevel confLevel = getPublicationsForPersonRequest.getPubConfidence();
                
                //Filter list of publications based on the confidence level
                switch(confLevel)
                {
                    case PUBLISHED:
                        //
                        break;
                    case ACCEPTED:
                        //
                        break;
                    case ENVISAGEDTOBEPUBLISHED:
                        //
                        break;
                }
                
                if(getPublicationsForPersonRequest.hasTimePeriod())
                {
                    Period time = getPublicationsForPersonRequest.getTimePeriod();
                    
                    //Filter list of publications based on time period
                }
               
                response = new GetPublicationsForPersonResponse();
                response.setPublications(personsPublications);
            }
            
        }
        catch(InvalidRequest e)
        {
        }
       
        return response;
    }

    @Override
    public GetPublicationsForGroupResponse getPublicationsForGroup(GetPublicationsForGroupRequest getPublicationsForGroupRequest) 
    {
        GetPublicationsForGroupResponse response = null;
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
                
        try
        {
            //Validate Request
            if(getPublicationsForGroupRequest == null || getPublicationsForGroupRequest.getGroupName().isEmpty() || getPublicationsForGroupRequest.getGroupName()== null || getPublicationsForGroupRequest.getPubConfidence() == null)
            {
                throw new InvalidRequest();
            }
            else
            {
                String groupName = getPublicationsForGroupRequest.getGroupName();
                //Find people belonging to group in database and get their associated publications
                
                
                ArrayList<PublicationEntity> personsPublications = null;
                
                PublicationConfidenceLevel confLevel = getPublicationsForGroupRequest.getPubConfidence();
                
                //Filter list of publications based on the confidence level
                switch(confLevel)
                {
                    case PUBLISHED:
                        //
                        break;
                    case ACCEPTED:
                        //
                        break;
                    case ENVISAGEDTOBEPUBLISHED:
                        //
                        break;
                }
                
                if(getPublicationsForGroupRequest.hasTimePeriod())
                {
                    Period time = getPublicationsForGroupRequest.getTimePeriod();
                    
                    //Filter list of publications based on time period
                }
               
                response = new GetPublicationsForGroupResponse();
                response.setPublications(personsPublications);  
            }
        }
        catch(InvalidRequest e)
        {
        }
       
        return response;
                
    }

    @Override
    public CalcAccreditationPointsForPersonResponse calcAccreditationPointsForPerson(CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest) 
    {
        CalcAccreditationPointsForPersonResponse response = null;
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
                
        try
        {
            //Validate Request
            if(calcAccreditationPointsForPersonRequest == null || calcAccreditationPointsForPersonRequest.getForWho() == null || calcAccreditationPointsForPersonRequest.getPubConfidence() == null)
            {
                throw new InvalidRequest();
            }
            else
            {
                //Get person publications
                PersonMock requester = calcAccreditationPointsForPersonRequest.getForWho();
                PublicationConfidenceLevel pubConfidence = calcAccreditationPointsForPersonRequest.getPubConfidence();
                
                Period timePeriod;
                GetPublicationsForPersonRequest getPublications;
                
                if(calcAccreditationPointsForPersonRequest.getTimePeriod() != null)
                {
                    timePeriod = calcAccreditationPointsForPersonRequest.getTimePeriod();
                    getPublications = new GetPublicationsForPersonRequest(requester, pubConfidence, timePeriod);
                }
                else
                {
                    getPublications = new GetPublicationsForPersonRequest(requester, pubConfidence);
                }
               
                GetPublicationsForPersonResponse publications = getPublicationsForPerson(getPublications);
                
                ArrayList<PublicationEntity> listOfPublications = publications.getPublications();
                
                //Get Publication types and associated points
               
                    //Get a list of all active publication types
                Query activeTypesQuery = entityManager.createQuery("Select pubType from PublicationType pubType JOIN pubType.typeState state WHERE TYPE(state) ='Active' ");
                ArrayList<PublicationTypeEntity> activeTypes = (ArrayList<PublicationTypeEntity>) activeTypesQuery.getResultList();
                
                    //Get names and points associated with active types
                ArrayList<String> namesOfTypes = new ArrayList<>();
                ArrayList<Double> typePoints = new ArrayList<>();
                
                for(PublicationTypeEntity type : activeTypes)
                {
                    namesOfTypes.add(type.getTypeName());
                    
                    Query pointsQuery = entityManager.createQuery("Select active.accreditationPoints from ActiveState active, PublicationType pubType WHERE active.activationID = pubType.typeState.activationID ");
                    typePoints.add((Double) pointsQuery.getSingleResult());
                }
                
                //Count publications that match types
                ArrayList<Integer> typeCount = new ArrayList<>();
                for(String typeName : namesOfTypes)
                {
                    int count = 0;
                    
                    for(PublicationEntity publication : listOfPublications)
                    {
                        PublicationStateEntity pubState = publication.getStateEntries().get(publication.getStateEntries().size());
                        String pubTypeName = pubState.getType().getTypeName();
                        
                        if(typeName.equals(pubTypeName))
                        {
                            count++;
                        }
                    }
                    
                    typeCount.add(count);
                }

                double points = 0;
                //Calculate points
                for(int i = 0; i > namesOfTypes.size(); i++)
                {
                    points = points + (typePoints.get(i) * typeCount.get(i));
                }
                
                //Create response
                response = new CalcAccreditationPointsForPersonResponse();
                response.setSumAccreditationPoints(points);
            }
        }
        catch(InvalidRequest e)
        {
        
        }
        
        return response; 
                
    }

    @Override
    public CalcAccreditationPointsForGroupResponse calcAccreditationPointsForGroup(CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest) 
    {
       CalcAccreditationPointsForGroupResponse response = null;
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
        
        try
        {
            //Validate Request
            if(calcAccreditationPointsForGroupRequest == null || calcAccreditationPointsForGroupRequest.getGroupName().isEmpty() || calcAccreditationPointsForGroupRequest.getGroupName()== null || calcAccreditationPointsForGroupRequest.getPubConfidence() == null)
            {
               throw new InvalidRequest(); 
            }
            else
            {
                //Get group publications
                String groupName = calcAccreditationPointsForGroupRequest.getGroupName();
                PublicationConfidenceLevel pubConfidence = calcAccreditationPointsForGroupRequest.getPubConfidence();
                
                Period timePeriod;
                GetPublicationsForGroupRequest getPublications;
                
                if(calcAccreditationPointsForGroupRequest.getTimePeriod() != null)
                {
                    timePeriod = calcAccreditationPointsForGroupRequest.getTimePeriod();
                    getPublications = new GetPublicationsForGroupRequest(groupName, pubConfidence, timePeriod);
                }
                else
                {
                    getPublications = new GetPublicationsForGroupRequest(groupName, pubConfidence);
                }
               
                GetPublicationsForGroupResponse publications = getPublicationsForGroup(getPublications);
                
                ArrayList<PublicationEntity> listOfPublications = publications.getPublications();
                
                //Get Publication types and associated points
                
                    //Get a list of all active publication types
                Query activeTypesQuery = entityManager.createQuery("Select pubType from PublicationType pubType JOIN pubType.typeState state WHERE TYPE(state) ='Active' ");
                ArrayList<PublicationTypeEntity> activeTypes = (ArrayList<PublicationTypeEntity>) activeTypesQuery.getResultList();
                
                    //Get names and points associated with active types
                ArrayList<String> namesOfTypes = new ArrayList<>();
                ArrayList<Double> typePoints = new ArrayList<>();
                
                for(PublicationTypeEntity type : activeTypes)
                {
                    namesOfTypes.add(type.getTypeName());
                    
                    Query pointsQuery = entityManager.createQuery("Select active.accreditationPoints from ActiveState active, PublicationType pubType WHERE active.activationID = pubType.typeState.activationID ");
                    typePoints.add((Double) pointsQuery.getSingleResult());
                }
                
                //Count publications that match types
                ArrayList<Integer> typeCount = new ArrayList<>();
                for(String typeName : namesOfTypes)
                {
                    int count = 0;
                    
                    for(PublicationEntity publication : listOfPublications)
                    {
                        PublicationStateEntity pubState = publication.getStateEntries().get(publication.getStateEntries().size());
                        String pubTypeName = pubState.getType().getTypeName();
                        
                        if(typeName.equals(pubTypeName))
                        {
                            count++;
                        }
                    }
                    
                    typeCount.add(count);
                }
                
                

                double points = 0;
                // Calculate points
                for(int i = 0; i > namesOfTypes.size(); i++)
                {
                    points = points + (typePoints.get(i) * typeCount.get(i));
                }
                
                //Create response
                response = new CalcAccreditationPointsForGroupResponse();
                response.setSumAccreditationPoints(points);
            }
        }
        catch(InvalidRequest e)
        {
        }
        
        return response;
    }

    @Override
    public ChangePublicationStateResponse changePublicationState(ChangePublicationStateRequest changePublicationStateRequest) throws NotAuthorized, NoSuchPublicationException, AlreadyPublishedException, PublicationWithTitleExistsForAuthors {

       Publication publication = null;
        
        if(!changePublicationStateRequest.isAuthorized())
        {
            throw(new NotAuthorized());
        }
        
        //publication = getPublication(new GetPublicationRequest(changePublicationStateRequest.getPublicationTitle()));
        if(publication==null)
        {
            throw(new NoSuchPublicationException());
        }
         PublicationState getState = publication.getPublicationStateObject().get(publication.getPublicationStateObject().size());
        if(getState.getLifeCycleStateObject().getStateString().equals("Published"))
        {
            throw(new AlreadyPublishedException());
        }

        //Persist
      

        addPublicationState(publication,getState);


        return new ChangePublicationStateResponse(publication);

        
    }

}
