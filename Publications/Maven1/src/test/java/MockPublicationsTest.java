/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author moses
 */
public class MockPublicationsTest {
    
    public MockPublicationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPublication method, of class MockPublications.
     */
    @Test
    public void testGetPublication() {
        System.out.println("getPublication");
        String title = "pub1";
        MockPublications instance = new MockPublications();    
        Publication result = instance.getPublication(title);
        Publication expResult = result;
        assertEquals(title, result.getTitle());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
