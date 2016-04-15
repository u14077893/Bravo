
package za.ac.cs.teambravo.publications.services;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.List;
>>>>>>> 4049fcc9c967af92f865119b8ad8ba284b52459d
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
import za.ac.cs.teambravo.publications.base.Publication;
import za.ac.cs.teambravo.publications.base.PublicationState;
=======


import za.ac.cs.teambravo.publications.entities.PublicationState;
import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;
import za.ac.cs.teambravo.publications.entities.ActiveState;




>>>>>>> 4049fcc9c967af92f865119b8ad8ba284b52459d
import za.ac.cs.teambravo.publications.exceptions.AlreadyPublishedException;
import za.ac.cs.teambravo.publications.exceptions.AuthorizationException;
import za.ac.cs.teambravo.publications.exceptions.EffectiveDateNotAfterEffectiveDateOfLastStateEntry;
import za.ac.cs.teambravo.publications.exceptions.InvalidRequest;
import za.ac.cs.teambravo.publications.exceptions.NoSuchPublicationException;
import za.ac.cs.teambravo.publications.exceptions.NotAuthorized;
import za.ac.cs.teambravo.publications.exceptions.PublicationTypeExistsException;
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

import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeResponse;

import za.ac.cs.teambravo.publications.entities.*;
import za.ac.cs.teambravo.publications.base.*;
import java.util.List;
import javax.persistence.Query;

import za.ac.cs.teambravo.publications.base.Active;

import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;
import za.ac.cs.teambravo.publications.entities.ActiveState;




import za.ac.cs.teambravo.publications.exceptions.AlreadyPublishedException;
import za.ac.cs.teambravo.publications.exceptions.AuthorizationException;
import za.ac.cs.teambravo.publications.exceptions.EffectiveDateNotAfterEffectiveDateOfLastStateEntry;
import za.ac.cs.teambravo.publications.exceptions.InvalidRequest;
import za.ac.cs.teambravo.publications.exceptions.NoSuchPublicationException;
import za.ac.cs.teambravo.publications.exceptions.NotAuthorized;
import za.ac.cs.teambravo.publications.exceptions.PublicationTypeExistsException;
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

import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeResponse;

import za.ac.cs.teambravo.publications.entities.*;
import za.ac.cs.teambravo.publications.base.*;

import za.ac.cs.teambravo.publications.base.Active;



/**
 *
 * @author Jedd, Hlengi, Moses, Gift, Kudzai, Vuyani
 */
@Stateless
public class PublicationsBean implements Publications, PublicationTypes 
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
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) throws AuthorizationException, PublicationTypeExistsException {
        
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
        EntityManager manager=factory.createEntityManager();
       
        PublicationType pTest = getPublicationType(addPublicationTypeRequest.getPublicationTypeObject());
        
        if(pTest == null) {
            throw new PublicationTypeExistsException("Publication type already exists.");
        }
        else
        {
             PublicationType pTnew = createPublicationType(pTest);
        
        // addStateEntry function here
        pTnew.addStateEntry(pTest.getTypeState());
        //persistObject funtion here
//        if(addPublicationTypeRequest.isIsActive())
//        {
//           // pTnew.
////            ActiveSta a = (Active)pTnew.getTypeStates().get( pTnew.getTypeStates().size()-1);
//            ActiveStateEntity as ;
//            as.setAccreditationPoints(pTnew.getTypeStates().get( pTnew.getTypeStates().size()-1).getAccreditationPoints);
//            
//        }
//        ActiveStateEntity pTE = (ActiveStateEntity) new PublicationTypeStateEntity();
//        pTE.setDateEffective(pTnew.getTypeStates().get( pTnew.getTypeStates().size()-1).getDateEffective());
//        pTE.setAccreditationPoints((pTnew.getTypeStates().get( pTnew.getTypeStates().size()-1).);
        
        manager.getTransaction().begin();
        manager.persist(pTnew.getTypeStates().get( pTnew.getTypeStates().size()-1));
        manager.persist(pTnew);
        manager.getTransaction().commit();
        //return response with pT
        AddPublicationTypeResponse aPR = new AddPublicationTypeResponse();
        aPR.setPublicationTypeEntity(pTnew);
        return aPR;
        }
        
       
        
    }

    @Override
    public ModifyPublicationTypeResponse modifyPublicationType(ModifyPublicationTypeRequest modifyPublicationTypeRequest) throws AuthorizationException, EffectiveDateNotAfterEffectiveDateOfLastStateEntry {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entityManager = emFactory.createEntityManager();
        
        List<PublicationType> pubTypeList = (List<PublicationType>)entityManager.createQuery("SELECT p FROM PublicationType p WHERE p.typeName ="+modifyPublicationTypeRequest.getPublicationTypeObject().getPublicationType())
                              .getResultList();
        
        PublicationType type = pubTypeList.get(pubTypeList.size()-1);
        PublicationTypeState typeState = type.getTypeStates().get(pubTypeList.size()-1);
        typeState.setEffectiveDate(modifyPublicationTypeRequest.getPublicationTypeStateObject().getEffectiveDate());
        type.getTypeStates().add(typeState);
        entityManager.getTransaction().begin();
        entityManager.persist(type);
        entityManager.getTransaction().commit();
        
        return new ModifyPublicationTypeResponse(type);
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
                Query typesQuery = entityManager.createQuery("Select pubType from PublicationTypeEntity pubType");
                ArrayList<PublicationTypeEntity> types = (ArrayList<PublicationTypeEntity>) typesQuery.getResultList();
                
                    //Get names and points associated with active types
                ArrayList<String> namesOfTypes = new ArrayList<>();
                ArrayList<Double> typePoints = new ArrayList<>();
                
                int numActiveTypes = 0;
                
                for(PublicationTypeEntity type : types)
                {
                    if(type.getTypeStates().get(type.getTypeStates().size()) instanceof ActiveStateEntity)
                    {
                        namesOfTypes.add(type.getTypeName());

                        Query pointsQuery = entityManager.createQuery("Select active.accreditationPoints from ActiveStateEntity active WHERE active.activationID = :id ");
                        pointsQuery.setParameter("id", type.getTypeStates().get(type.getTypeStates().size()).getId());
                        typePoints.add((Double) pointsQuery.getSingleResult());
                        
                        numActiveTypes++;
                    }
                }
                
                //Count publications that match types
                ArrayList<Integer> typeCount = new ArrayList<>();
                for(String typeName : namesOfTypes)
                {
                    int count = 0;
                    
                    for(PublicationEntity publication : listOfPublications)
                    {
                       if(publication.getStateEntries().get(publication.getStateEntries().size()).getType().getTypeName().equals(typeName))
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
                Query typesQuery = entityManager.createQuery("Select pubType from PublicationTypeEntity pubType");
                ArrayList<PublicationTypeEntity> types = (ArrayList<PublicationTypeEntity>) typesQuery.getResultList();
                
                    //Get names and points associated with active types
                ArrayList<String> namesOfTypes = new ArrayList<>();
                ArrayList<Double> typePoints = new ArrayList<>();
                
                int numActiveTypes = 0;
                
                for(PublicationTypeEntity type : types)
                {
                    if(type.getTypeStates().get(type.getTypeStates().size()) instanceof ActiveStateEntity)
                    {
                        namesOfTypes.add(type.getTypeName());

                        Query pointsQuery = entityManager.createQuery("Select active.accreditationPoints from ActiveStateEntity active WHERE active.activationID = :id ");
                        pointsQuery.setParameter("id", type.getTypeStates().get(type.getTypeStates().size()).getId());
                        typePoints.add((Double) pointsQuery.getSingleResult());
                        
                        numActiveTypes++;
                    }
                }
                
                //Count publications that match types
                ArrayList<Integer> typeCount = new ArrayList<>();
                for(String typeName : namesOfTypes)
                {
                    int count = 0;
                    
                    for(PublicationEntity publication : listOfPublications)
                    {
                       if(publication.getStateEntries().get(publication.getStateEntries().size()).getType().getTypeName().equals(typeName))
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
<<<<<<< HEAD
         PublicationState getState = publication.getPublicationStateObject().get(publication.getPublicationStateObject().size());
=======
         PublicationState getState =publication.getPublicationStateObject().peek();
>>>>>>> 4049fcc9c967af92f865119b8ad8ba284b52459d
        if(getState.getLifeCycleStateObject().getStateString().equals("Published"))
        {
            throw(new AlreadyPublishedException());
        }


        addPublicationState(publication,getState);


        return new ChangePublicationStateResponse(publication);

        
    }

    @Override
    public PublicationType getPublicationType(PublicationType pubType) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      TypedQuery<PublicationType> query;
        query = entitymanager.createNamedQuery("PublicationType.findBytypeName", PublicationType.class).setParameter("typeName", pubType.getTypeName());
      List<PublicationType> result = query.getResultList();
      
       if(result.isEmpty())
           return null;
       else
           return pubType;
    }

    @Override
    public PublicationType createPublicationType(PublicationType p) {
        PublicationType pE = null;
        pE.setTypeName(p.getTypeName());
        return pE;
    }

   

}
