
package za.ac.cs.teambravo.publications.services;

import java.util.ArrayList;
import java.util.Date;


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
import javax.validation.constraints.NotNull;
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
        
        PublicationState publicationState = addPublicationRequest.publicationState;
     PersonMock owner = publicationState.getPublicationDetailsObject().getPerson();
     
        
        //He/she is one of the authors of the publication.
        
        String nameSurname = publicationState.getPublicationDetailsObject().getPerson().getFirstName() + " " + publicationState.getPublicationDetailsObject().getPerson().getSurname();
        Boolean authorsFlag = false;
        
        for(int i = 0; i < publicationState.getPublicationDetailsObject().getAuthors().size(); i++)
        {
              String authorsNameSurname = publicationState.getPublicationDetailsObject().getAuthors().get(i).getFirstName() +
                      " " + publicationState.getPublicationDetailsObject().getAuthors().get(i).getSurname();
              if(nameSurname.equals(authorsNameSurname))
              {
                  authorsFlag = true;
                  break;
              }
        }
        
        if(authorsFlag == false)
        {
            throw new NotAuthorized();
        }
        
       //The user is a research group leader and at least one of the authors is a member of the research group.
        
        Boolean groupLeaderFlag = false;
        
        if(owner.getResearchGroupAssociationType().equals("groupLeader"))
        {
            groupLeaderFlag = true;
        }
       
        String researchGroup = owner.getResearchCategory();
        Boolean researchGroupFlag = false;
        for(int i = 0; i < publicationState.getPublicationDetailsObject().getAuthors().size(); i++)
        {
            if(researchGroup.equals(publicationState.getPublicationDetailsObject().getAuthors().get(i).getResearchCategory()))
            {
                researchGroupFlag = true;
                break;
            }
            if(researchGroupFlag == true)
            {
                break;
            }
        }
        
        if(groupLeaderFlag == false && researchGroupFlag == false)
        {
            throw new NotAuthorized();
        }
        
        // everything seems okay
        // check if the publication is already in the database
        GetPublicationRequest tmpGetPubRequest = new GetPublicationRequest(publicationState.getPublicationDetailsObject().getTitle());
        GetPublicationResponse tmpResponse = null;
        try {
            tmpResponse = getPublication(tmpGetPubRequest);
        } catch (PublicationWithTitleExistsForAuthors ex) {
                System.out.println(ex.getMessage());
        }
        
       if(tmpResponse != null)  //initialised publication is returned
        {
            try {
                throw new PublicationWithTitleExistsForAuthors("Publication already exists.");
            } catch (PublicationWithTitleExistsForAuthors ex) {
                ex.getMessage();
            }
        }
        
      
       CreatePublicationRequest createRequest = new CreatePublicationRequest(addPublicationRequest.publicationState);
       CreatePublicationResponse createResponse = new CreatePublicationResponse(createRequest.getPublicationState());
        try {
            createResponse = createPublication(createRequest);
        } catch (InvalidRequest ex) {
            System.out.println(ex.getMessage());
        }
       
       PublicationState stateToPersist = createResponse.getNewPublicationState();
       
       if(stateToPersist == null)
       {
           return null;
           //create a response object, with null and return that
       } //  otherwise persist
       else
       {
          persistObject(stateToPersist);
       }
       
        return null;
    
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void persistObject(PublicationState stateToPersist)
    {
    
        EntityManagerFactory emfactory = Persistence.
       // createEntityManagerFactory( "Eclipselink_JPA" );
        createEntityManagerFactory( "EntityDemoPU" );
        EntityManager entitymanager = emfactory.
        createEntityManager( );
        entitymanager.getTransaction( ).begin( );
        
      
      /*    //persist person
       PersonEntity person = new PersonEntity();
       person.setFirstNames(stateToPersist.getPublicationDetailsObject().getPersonObject().getFirstName());
       person.setSurname(stateToPersist.getPublicationDetailsObject().getPersonObject().getSurname());
       person.setGroupName(stateToPersist.getPublicationDetailsObject().getPersonObject().getGroupName());
       entitymanager.persist(person); */
       
       
       //persist publicationTarget
       PublicationTargetEntity pubTarget = new PublicationTargetEntity();
       pubTarget.setName(stateToPersist.getPublicationTargetObject().getName());
       pubTarget.setWebsite(stateToPersist.getPublicationTargetObject().getWebsite().toString());
       entitymanager.persist(pubTarget);
       
       //Adding list of authors to db
       ArrayList<PersonEntity> tmpList = new ArrayList();
       PersonEntity tmpPersonEntity = new PersonEntity();
       for(int i = 0; i < stateToPersist.getPublicationDetailsObject().getAuthors().size();i++)
       {
           tmpPersonEntity.setFirstName(stateToPersist.getPublicationDetailsObject().getAuthors().get(i).getFirstName());
           tmpPersonEntity.setSurname(stateToPersist.getPublicationDetailsObject().getAuthors().get(i).getSurname());
           tmpPersonEntity.setGroupName(stateToPersist.getPublicationDetailsObject().getAuthors().get(i).getGroupName()); 
           tmpList.add(tmpPersonEntity);
       }
       
       ArrayList<PersonEntity> authorList = new ArrayList();
       for(int i = 0; i < tmpList.size() ; i++)
       {
          entitymanager.persist(tmpList.get(i));
          authorList.add(tmpList.get(i));
       }
       
       //persist publicationDetails
       PublicationDetailsEntity pubDetails =  new PublicationDetailsEntity();
       pubDetails.setTitle(stateToPersist.getPublicationDetailsObject().getTitle());
       pubDetails.setEnvisagedPublicationDate(stateToPersist.getPublicationDetailsObject().getEnvisagedPublicationDate());
       pubDetails.setAuthors(authorList);
       entitymanager.persist(pubDetails);
       
       // adding life cycle state
       
        //LifeCycleStateEntity state = null;
       
        
        PublicationStateEntity pubState = new PublicationStateEntity();
       
        pubState.setDetails(pubDetails);
        pubState.setTarget(pubTarget);
        //state done in the function
        //type done below
        
       if(stateToPersist.getLifeCycleStateObject().getState().equals("InProgress"))
       {
           InProgressEntity state = new InProgressEntity();
           state.setPercentageComplete(stateToPersist.getLifeCycleStateObject().getPercentageCompleted());
           entitymanager.persist(state);
           pubState.setState(state);
       }
       
       if(stateToPersist.getLifeCycleStateObject().getState().equals("Published"))
       {
          PublishedEntity state = new PublishedEntity();
           state.setPublicationDate(stateToPersist.getLifeCycleStateObject().getPublicationDate());
           state.setBibTexReference(stateToPersist.getLifeCycleStateObject().getBibTexEntry());
           
           entitymanager.persist(state);
           pubState.setState(state);
       }
       
       if(stateToPersist.getLifeCycleStateObject().getState().equals("Submitted"))
       {
          SubmittedEntity  state = new SubmittedEntity();
           entitymanager.persist(state);
           pubState.setState(state);
       }
       
       if(stateToPersist.getLifeCycleStateObject().getState().equals("Accepted"))
       {
           AcceptedEntity state = new AcceptedEntity();
           entitymanager.persist(state);
           pubState.setState(state);
       }
       
        if(stateToPersist.getLifeCycleStateObject().getState().equals("Abandoned"))
       {
          AbandonedEntity state = new AbandonedEntity();
           entitymanager.persist(state);
           pubState.setState(state);
       }
        
       if(stateToPersist.getLifeCycleStateObject().getState().equals("Rejected"))
       {
          RejectedEntity state = new RejectedEntity();
           entitymanager.persist(state);
           pubState.setState(state);
       }
       
       //publication type
    
       
       TypedQuery<PublicationTypeEntity> query = entitymanager.createNamedQuery("PublicationType.findBytypeName", PublicationTypeEntity.class);
       query.setParameter("type", stateToPersist.getPublicationTypeObject().getName()); 
       List results = query.getResultList();
       
       PublicationTypeEntity type = (PublicationTypeEntity)  results.get(0);
       
      //  PublicationStateEntity pubState = new PublicationStateEntity();
       
       // pubState.setDetails(pubDetails);
        //pubState.setTarget(pubTarget);
        //state done in the function
        pubState.setType(type);
       
        entitymanager.persist(pubState);
        entitymanager.getTransaction().commit();
        
    }
    
    
    
     
     public Boolean validStateElements(@NotNull Date date, @NotNull String reason)
   {    
       return !reason.isEmpty();
   }
   
   public Boolean validatePublicationTarget(@NotNull PublicationTarget publicationTarget)
   {
       if(publicationTarget.getWebsite() == null || publicationTarget.getName().isEmpty())
       {
           return false;
       }
       return true;
   }
   
   public Boolean validatePublicationDetails(@NotNull PublicationDetails publicationDetails)
   {
       
       if(publicationDetails.getTitle().isEmpty() ||
          publicationDetails.getAuthors().size() < 0 ||
          publicationDetails.getEnvisagedPublicationDate() == null ||
          publicationDetails.getPerson().getFirstName().isEmpty() || 
          publicationDetails.getPerson().getSurname().isEmpty() ||
          publicationDetails.getPerson().getEmailAdress().isEmpty() ||
          publicationDetails.getPerson().getOrganizationName().isEmpty() ||
          publicationDetails.getPerson().getResearchCategory().isEmpty() ||
          publicationDetails.getPerson().getResearchCategoryAssociationEffectiveDate() == null  ||
          publicationDetails.getPerson().getResearchCategoryStateEffectiveDate() == null ||
          publicationDetails.getPerson().getResearchCategoryStateResearchOutputTarget() < 0 ||
          publicationDetails.getPerson().getResearchGroupAssociationEndDate() == null ||
          publicationDetails.getPerson().getResearchGroupAssociationStartDate() == null ||
          publicationDetails.getPerson().getResearchGroupAssociationType().isEmpty() )
       {
           return false;
       }
       return true;
   }
   
   public Boolean validatePublicationType(@NotNull PublicationType publicationType)
   {
       return !(publicationType.getName().isEmpty() ||
               publicationType.getTypeStates().size() < 1);
   }
 
   public Boolean validateLifeCycleState(@NotNull LifeCycleState lifeCycleState)
   {
       boolean validState = false;
       if(lifeCycleState.getState().equals("InProgress") || lifeCycleState.getState().equals("InRevision") ||
          lifeCycleState.getState().equals("Published") || lifeCycleState.getState().equals("Abandoned") ||
          lifeCycleState.getState().equals("Submitted") || lifeCycleState.getState().equals("Rejected"))
       {
           validState = true;
       }
       
       if(validState)
       {
           if(lifeCycleState.getState().equals("InProgress"))
           {
               if(lifeCycleState.getPercentageCompleted() < 0 || lifeCycleState.getPercentageCompleted() > 100)
                   return false;
               if(!lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() != null)
                   return false;
               
               return true;
           }
           
            if(lifeCycleState.getState().equals("Published"))
           {
               if(lifeCycleState.getPercentageCompleted() != null)
                   return false;
               if(lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() == null)
                   return false;
               
               return true;
           }
           
            if(lifeCycleState.getState().equals("Rejected"))
           {
               if(lifeCycleState.getPercentageCompleted() != null)
                   return false;
               if(!lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() != null)
                   return false;
               
               return true;
           }
           
             if(lifeCycleState.getState().equals("Submitted"))
           {
               if(lifeCycleState.getPercentageCompleted() != null)
                   return false;
               if(!lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() != null)
                   return false;
               
               return true;
           }
           
              if(lifeCycleState.getState().equals("Abandoned"))
           {
               if(lifeCycleState.getPercentageCompleted() != null)
                   return false;
               if(!lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() != null)
                   return false;
               
               return true;
           }
             
               if(lifeCycleState.getState().equals("InRevision"))
           {
               if(lifeCycleState.getPercentageCompleted() != null)
                   return false;
               if(!lifeCycleState.getBibTexEntry().isEmpty())
                   return false;
               if(lifeCycleState.getPublicationDate() != null)
                   return false;
               
               return true;
           } 
            
       }    
       return true;
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
        AddPublicationTypeResponse aPR = new AddPublicationTypeResponse();
        
        try
        {
            EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU"); //"JPA1" is the project name and the "PU" is added by the system
            EntityManager manager=factory.createEntityManager();
            
            // Get publication type if it exists
            PublicationType pTest = getPublicationType(addPublicationTypeRequest.getPublicationTypeObject());

            if(pTest != null) {
                throw new PublicationTypeExistsException("Publication type already exists.");
            }
            else
            {
                 PublicationTypeEntity pTnew = createPublicationType(addPublicationTypeRequest.getPublicationTypeObject());

            // addStateEntry function here
            pTnew.addStateEntry(pTnew.getTypeStates().get(pTest.getTypeStates().size()-1));
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
//            aPR  = new AddPublicationTypeResponse();
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
    
    //@Override
    public DeactivatePublicationTypeResponse deactivatePublicationType(DeactivatePublicationTypeRequest deactivatePublicationTypeResponse){
        
        return null;
    }
   /* @Override
    public DeactivatePublicationTypeResponse deactivatePublicationType(DeactivatePublicationTypeRequest deactivatePublicationTypeResponse){
        
    }*/

    
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

        if(getState.getLifeCycleStateObject().getState().equals("Published"))
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

    public PublicationTypeEntity createPublicationType(PublicationType p) {
        PublicationTypeEntity pE = new PublicationTypeEntity();
        pE.setTypeName(p.getPublicationType());
        PublicationTypeStateEntity publicationTypeStateEntity = new PublicationTypeStateEntity();
        publicationTypeStateEntity.setDateEffective(p.getTypeStates().get(p.getTypeStates().size()-1).getEffectiveDate());
        List<PublicationTypeStateEntity> list = new ArrayList<>();
        list.add(publicationTypeStateEntity);
        pE.setTypeStates(list);
        return pE;
    }

   

}
