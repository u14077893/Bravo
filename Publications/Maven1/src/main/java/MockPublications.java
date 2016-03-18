/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moses
 */
public class MockPublications implements Publications
{
    @Override
    public Publication getPublication(String title)
    {
        MockPublication mockObject=new MockPublication("pub1","Book", "Decemeber paper", "www.cs.up.ac.za");
        return mockObject;
    }
}
