/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.services;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.embeddable.EJBContainer;
import org.junit.Test;
import static org.junit.Assert.*;
import za.ac.cs.teambravo.publications.base.Active;
import za.ac.cs.teambravo.publications.base.PublicationType;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;
import za.ac.cs.teambravo.publications.entities.ActiveStateEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeEntity;
import za.ac.cs.teambravo.publications.entities.PublicationTypeStateEntity;
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
 * @author User
 */
public class PublicationsBeanTest {
    
    public PublicationsBeanTest() {
    }
    
   
    /**
     * Test of addPublication method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddPublication() throws Exception {
        System.out.println("addPublication");
        AddPublicationRequest addPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        AddPublicationResponse expResult = null;
        AddPublicationResponse result = instance.addPublication(addPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublication method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPublication() throws Exception {
        System.out.println("getPublication");
        GetPublicationRequest getPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationResponse expResult = null;
        GetPublicationResponse result = instance.getPublication(getPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createPublication method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreatePublication() throws Exception {
        System.out.println("createPublication");
        CreatePublicationRequest createPublicationRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        CreatePublicationResponse expResult = null;
        CreatePublicationResponse result = instance.createPublication(createPublicationRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPublicationType method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddPublicationType() throws Exception {
        
        PublicationType publicationType = new PublicationType();
        PublicationTypeEntity publicationTypeEntity = new PublicationTypeEntity();
        
        PublicationTypeState publicationTypeState = new Active();
        PublicationTypeStateEntity publicationTypeStateEntity = new ActiveStateEntity();
        
        ArrayList<PublicationTypeState> typeStates = new ArrayList<>();
        ArrayList<PublicationTypeStateEntity> typeStatesEntity = new ArrayList<>();
        
        typeStates.add(publicationTypeState);
        typeStatesEntity.add(publicationTypeStateEntity);
        
        Date date = new Date(1994, 02, 10);
        publicationTypeState.setEffectiveDate(date);
        publicationTypeStateEntity.setDateEffective(date);
        
        publicationType.setName("Book");
        publicationTypeEntity.setTypeName("Book");
        
        publicationType.setPublicationType("Book");
        publicationTypeEntity.setTypeName("Book");
        
        publicationType.setTypeStates(typeStates);
        publicationTypeEntity.setTypeStates(typeStatesEntity);
        
        AddPublicationTypeRequest aPTR = new AddPublicationTypeRequest(publicationType);
        AddPublicationTypeResponse aP = new AddPublicationTypeResponse();
        aP.setPublicationTypeEntity(publicationTypeEntity);
        
        System.out.println("addPublicationType");
        AddPublicationTypeRequest addPublicationTypeRequest = aPTR;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        AddPublicationTypeResponse expResult = aP;
        AddPublicationTypeResponse result = instance.addPublicationType(addPublicationTypeRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        
                
        fail("The test case is a prototype.");
    }

    /**
     * Test of modifyPublicationType method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testModifyPublicationType() throws Exception {
        System.out.println("modifyPublicationType");
        ModifyPublicationTypeRequest modifyPublicationTypeRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        ModifyPublicationTypeResponse expResult = null;
        ModifyPublicationTypeResponse result = instance.modifyPublicationType(modifyPublicationTypeRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublicationsForPerson method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPublicationsForPerson() throws Exception {
        System.out.println("getPublicationsForPerson");
        GetPublicationsForPersonRequest getPublicationsForPersonRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationsForPersonResponse expResult = null;
        GetPublicationsForPersonResponse result = instance.getPublicationsForPerson(getPublicationsForPersonRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublicationsForGroup method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPublicationsForGroup() throws Exception {
        System.out.println("getPublicationsForGroup");
        GetPublicationsForGroupRequest getPublicationsForGroupRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        GetPublicationsForGroupResponse expResult = null;
        GetPublicationsForGroupResponse result = instance.getPublicationsForGroup(getPublicationsForGroupRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcAccreditationPointsForPerson method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testCalcAccreditationPointsForPerson() throws Exception {
        System.out.println("calcAccreditationPointsForPerson");
        CalcAccreditationPointsForPersonRequest calcAccreditationPointsForPersonRequest = null;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
            CalcAccreditationPointsForPersonResponse expResult = null;
            CalcAccreditationPointsForPersonResponse result = instance.calcAccreditationPointsForPerson(calcAccreditationPointsForPersonRequest);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcAccreditationPointsForGroup method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testCalcAccreditationPointsForGroup() throws Exception {
        System.out.println("calcAccreditationPointsForGroup");
        CalcAccreditationPointsForGroupRequest calcAccreditationPointsForGroupRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        CalcAccreditationPointsForGroupResponse expResult = null;
        CalcAccreditationPointsForGroupResponse result = instance.calcAccreditationPointsForGroup(calcAccreditationPointsForGroupRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePublicationState method, of class PublicationsBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testChangePublicationState() throws Exception {
        System.out.println("changePublicationState");
        ChangePublicationStateRequest changePublicationStateRequest = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        Publications instance = (Publications)container.getContext().lookup("java:global/classes/PublicationsBean");
        ChangePublicationStateResponse expResult = null;
        ChangePublicationStateResponse result = instance.changePublicationState(changePublicationStateRequest);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
