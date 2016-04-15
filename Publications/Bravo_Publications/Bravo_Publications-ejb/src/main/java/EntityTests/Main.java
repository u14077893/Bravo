/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityTests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import za.ac.cs.teambravo.publications.entities.AcceptedEntity;
import za.ac.cs.teambravo.publications.entities.ActiveStateEntity;
import za.ac.cs.teambravo.publications.entities.InProgressEntity;
import za.ac.cs.teambravo.publications.entities.NotActiveStateEntity;
import za.ac.cs.teambravo.publications.entities.PersonEntity;
import za.ac.cs.teambravo.publications.entities.PublicationDetailsEntity;
import za.ac.cs.teambravo.publications.entities.PublicationEntity;
import za.ac.cs.teambravo.publications.entities.PublicationStateEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTargetEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeStateEntity;
import za.ac.cs.teambravo.publications.entities.PublishedEntity;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationRequest;
import za.ac.cs.teambravo.publications.requestandresponses.GetPublicationResponse;

/**
 *
 * @author moses
 */


public class Main 
{
    public static void createPublication()
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU");
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
               
        //1
        InProgressEntity prog = new InProgressEntity();
        prog.setPercentageComplete(65); 
        manager.persist(prog);
        
        //2
        PublicationTargetEntity target = new PublicationTargetEntity();
        target.setName("Google");
        target.setWebsite("www.google.com");    
        manager.persist(target);
        
        //3
        ActiveStateEntity as = new ActiveStateEntity();
        as.setDateEffective(new Date("2016/06/01"));
        as.setAccreditationPoints(1.5);
        manager.persist(as);
        
        //4
        List<PublicationTypeStateEntity> typeStates = new ArrayList();
        typeStates.add(as);
        
        PublicationTypeEntity type = new PublicationTypeEntity();       
        type.setTypeName("Book1");
        type.setTypeStates(typeStates);
        manager.persist(type);
        
        //5
        PersonEntity f=new PersonEntity();
        f.setFirstName("Mosco");
        f.setSurname("Goku");
        manager.persist(f);
        
        //6
        PublicationDetailsEntity details = new PublicationDetailsEntity();
        details.setTitle("Bananas");
        details.setEnvisagedPublicationDate(new Date("2016/11/16"));
        List<PersonEntity> personList = new ArrayList();
        personList.add(f);
        manager.persist(details);
        
        //7
        PublicationStateEntity pubState = new PublicationStateEntity();
        pubState.setDate(new Date("2016/04/04"));
        pubState.setReason("Start");
        pubState.setDetails(details);
        pubState.setTarget(target);
        pubState.setState(prog);    //Must be setLifeCycleState
        pubState.setType(type);    
        manager.persist(pubState);
        
        //8
        List<PublicationStateEntity> stateList = new ArrayList();        
        stateList.add(pubState);
        
        PublicationEntity pub = new PublicationEntity();
        pub.setStateEntries(stateList);        
        manager.persist(pub);
        int id=pub.getPublicationID();
        manager.getTransaction().commit();
        
    }
    
    public static void createPublication2()
    {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("EntityDemoPU");
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
 
        //1
        PublishedEntity prog = new PublishedEntity();
        prog.setPublicationDate(new Date("2014/07/07"));
        prog.setBibTexReference("xyz123");
        manager.persist(prog);
        
        //2
        PublicationTargetEntity target = new PublicationTargetEntity();
        target.setName("yahoo");
        target.setWebsite("www.yahoo.com");    
        manager.persist(target);
        
        //3
        ActiveStateEntity as = new ActiveStateEntity();
        as.setDateEffective(new Date("2014/06/16"));
        as.setAccreditationPoints(5.0);
        manager.persist(as);
        
        //4
        List<PublicationTypeStateEntity> typeStates = new ArrayList();
        typeStates.add(as);
        
        PublicationTypeEntity type = new PublicationTypeEntity();       
        type.setTypeName("yahoo");
        type.setTypeStates(typeStates);
        manager.persist(type);
        
        //5
        PersonEntity f=new PersonEntity();
        f.setFirstName("Simon");
        f.setSurname("yahoo");
        manager.persist(f);
        
        //6
        PublicationDetailsEntity details = new PublicationDetailsEntity();
        details.setTitle("yahoo");
        details.setEnvisagedPublicationDate(new Date("2016/02/12"));
        List<PersonEntity> personList = new ArrayList();
        personList.add(f);
        manager.persist(details);
        
        //7
        PublicationStateEntity pubState = new PublicationStateEntity();
        pubState.setDate(new Date("2016/02/02"));
        pubState.setReason("Init");
        pubState.setDetails(details);
        pubState.setTarget(target);
        pubState.setState(prog);    //Must be setLifeCycleState
        pubState.setType(type);    
        manager.persist(pubState);
        
    //**************************************************************************    
        
        //add a new state to an existing publication
        //1
        AcceptedEntity prog2 = new AcceptedEntity();
        manager.persist(prog2);
        
        //2
        PublicationTargetEntity target2 = new PublicationTargetEntity();
        target2.setName("fresh");
        target2.setWebsite("www.fresh.com");    
        manager.persist(target2);
        
        //3
        NotActiveStateEntity as2 = new NotActiveStateEntity();
        as2.setDateEffective(new Date("2015/1/1"));
        as2.setDeactivationReason("Not relevent");
        manager.persist(as2);
        
        //4
        List<PublicationTypeStateEntity> typeStates2 = new ArrayList();
        typeStates2.add(as2);
        
        PublicationTypeEntity type2 = new PublicationTypeEntity();       
        type2.setTypeName("book");
        type2.setTypeStates(typeStates2);
        manager.persist(type2);
        
        //5
        PersonEntity f2=new PersonEntity();
        f2.setFirstName("Charity");
        f2.setSurname("Mountain");
        manager.persist(f2);
        
        //6
        PublicationDetailsEntity details2 = new PublicationDetailsEntity();
        details2.setTitle("Fresh");
        details2.setEnvisagedPublicationDate(new Date("2015/09/09"));
        List<PersonEntity> personList2 = new ArrayList();
        personList2.add(f2);
        manager.persist(details2);
        
        //7
        PublicationStateEntity pubState2 = new PublicationStateEntity();
        pubState2.setDate(new Date("2015/5/24"));
        pubState2.setReason("news");
        pubState2.setDetails(details2);
        pubState2.setTarget(target2);
        pubState2.setState(prog2);    //Must be setLifeCycleState
        pubState2.setType(type2);    
        manager.persist(pubState2);
        
    //**************************************************************************    
        //8
        List<PublicationStateEntity> stateList = new ArrayList();        
        stateList.add(pubState);
        stateList.add(pubState2);
        
        PublicationEntity pub = new PublicationEntity();
        pub.setStateEntries(stateList);        
        manager.persist(pub);
        manager.getTransaction().commit();
        
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
    
    
    public static GetPublicationResponse getPublication(GetPublicationRequest request)
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
    public static void main(String[] args)
    {         
        GetPublicationRequest req=new GetPublicationRequest("Yellows");
        GetPublicationResponse res=getPublication(req);
        
        if(res!=null)
            System.out.println("ID:"+res.getPublicationObject().getPublicationID());
        else
            System.out.println("Not found");
        
    }
}
