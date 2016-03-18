/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.publicationtypes.*;
import com.mycompany.publicationtypes.PublicationTypes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kudzai
 */
public class PublicationTypesJUnitTest {
    
    public PublicationTypesJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void TestAddPublicationType() 
     {
        String expected = "New publication type has been added to the publications database";
        PublicationsTypeMock p = new PublicationsTypeMock();
        AddPublicationTypeRequestMock r;
        r = new AddPublicationTypeRequestMock();
        String actual = p.addPublicationType(r).getType();
         assertEquals(expected, actual);
     }
}
