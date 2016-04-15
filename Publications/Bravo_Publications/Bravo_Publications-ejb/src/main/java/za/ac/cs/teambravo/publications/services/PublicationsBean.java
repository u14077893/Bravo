
package za.ac.cs.teambravo.publications.services;

import java.util.ArrayList;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import za.ac.cs.teambravo.publications.base.Publication;
import za.ac.cs.teambravo.publications.base.PublicationState;
import za.ac.cs.teambravo.publications.entities.*;
import za.ac.cs.teambravo.publications.base.*;
import java.util.List;
import javax.persistence.Query;
import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;
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
import za.ac.cs.teambravo.publications.requestandresponses.DeactivatePublicationTypeResponse;
import za.ac.cs.teambravo.publications.requestandresponses.DeactivatePublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeRequest;
import za.ac.cs.teambravo.publications.requestandresponses.ReactivatePublicationTypeResponse;





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

    
    public static int getPublicationId(int stateid)
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU");
        EntityManager manager=factory.createEntityManager();
        
        TypedQuery<PublicationEntity> query= manager.createNamedQuery("PublicationEntity.findAll",PublicationEntity.class);
        List results=query.getResultList();
        int pubRows=results.size();
        
        PublicationEntity tempPublication;
        List statesList;
        int tempSize=0;
        PublicationStateEntity tempPubState;
        for(int i=0;i<pubRows;i++)
        {
            tempPublication=(PublicationEntity)results.get(i);
            statesList=tempPublication.getStateEntries();
            tempSize=statesList.size();
            for(int x=0;x<tempSize;x++)
            {
                tempPubState=(PublicationStateEntity)statesList.get(x);
                //System.out.println(tempPubState.getPublicationID()+":"+tempPubState.getDate());
                
                if(tempPubState.getPublicationID()==stateid)
                    return tempPublication.getPublicationID();  //id is here
            }    
        }
        return 0;
    }
    
    @Override
    public GetPublicationResponse getPublication(GetPublicationRequest request)
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU");
        EntityManager manager=factory.createEntityManager();
        
        String title=request.getTitle();
        
        TypedQuery<PublicationDetailsEntity> query= manager.createNamedQuery("PublicationDetailsEntity.findTitle",PublicationDetailsEntity.class);
        query.setParameter("title", title);     //name is what I am searching by, 'red meat' is the search
        
        List results=query.getResultList();
        
        int rows=results.size();
        
        if(rows==0)
        {
            System.out.println("Publication not found.");
            return null;
        }
        else 
        {
            PublicationDetailsEntity detObject=(PublicationDetailsEntity) results.get(0);
            int id=detObject.getDetailsID();
            //System.out.println("Detail found with id:"+id);
            
            TypedQuery<PublicationStateEntity> queryStateObject;
            queryStateObject = manager.createNamedQuery("PublicationStateEntity.findByDetails",PublicationStateEntity.class);
            queryStateObject.setParameter("detailsObject", detObject);
            
            List stateResults=queryStateObject.getResultList();
            
            PublicationStateEntity pubStateObject= (PublicationStateEntity) stateResults.get(0);
            //System.out.println("State found with id:"+pubStateObject.getPublicationID());
            
            int thePublication=getPublicationId(pubStateObject.getPublicationID());
            
            
            //To search by ID
            PublicationEntity publication=manager.find(PublicationEntity.class, thePublication);
            //System.out.println(publication.getPublicationID());
            
            GetPublicationResponse response=new GetPublicationResponse(publication);
            return response;
        }
    }
    /*public GetPublicationResponse getPublication(GetPublicationRequest getPublicationRequest) throws PublicationWithTitleExistsForAuthors {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

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
    public AddPublicationTypeResponse addPublicationType(AddPublicationTypeRequest addPublicationTypeRequest) 
    {
        AddPublicationTypeResponse aPR = null;
        
        try
        {
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
            pTnew.addStateEntry(pTest.getTypeStates().get(pTest.getTypeStates().size()));
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
            aPR  = new AddPublicationTypeResponse();
            aPR.setPublicationTypeEntity(pTnew);
            
            }
        }
        catch(Exception e)
        {
            
        }
        return aPR;
    }
    
    /**
     * 
     * @param modifyPublicationTypeRequest This request must have the new effective date of the entity state, and the name of the publication type to be changed.
     * @return returns a modify publication response with the entity that has just been inserted to the db.
     * @throws AuthorizationException
     * @throws EffectiveDateNotAfterEffectiveDateOfLastStateEntry 
     */
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
        
        return new ModifyPublicationTypeResponse();
    }
    
    @Override
    public DeactivatePublicationTypeResponse deactivatePublicationType(DeactivatePublicationTypeRequest deactivatePublicationTypeResponse){
        
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
                //Get person and their associated publications
                
                
                //Filter list of publications based on time period and pub confidence level
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
        
         PublicationState getState = publication.getPublicationStateObject().get(publication.getPublicationStateObject().size());

        if(getState.getLifeCycleStateObject().getStateString().equals("Published"))
        {
            throw(new AlreadyPublishedException());
        }


        addPublicationState(publication,getState);


        return new ChangePublicationStateResponse(publication);

        
    }

    public PublicationType getPublicationType(PublicationType pubType) {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "EntityDemoPU" );
      EntityManager entitymanager = emfactory.createEntityManager();
      
      TypedQuery<PublicationTypeEntity> query;
        query = entitymanager.createNamedQuery("PublicationType.findBytypeName", PublicationTypeEntity.class).setParameter("typeName", pubType.getName());
      List<PublicationTypeEntity> result = query.getResultList();
      
       if(result.isEmpty())
           return null;
       else
           return pubType;
    }

    public PublicationType createPublicationType(PublicationType p) {
        PublicationType pE = new PublicationType();
        pE.setName(p.getName());
        return pE;
    }

   

}
