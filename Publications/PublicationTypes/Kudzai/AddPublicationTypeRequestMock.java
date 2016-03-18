/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.publicationtypes;


public class AddPublicationTypeRequestMock implements AddPublicationTypeRequest {

    private String Type;
    public AddPublicationTypeRequestMock()
    {
        Type ="New publication type has been added to the publications database";
    }
    
     public void setType(String m)
     {
         Type = m;
     }
     
     public String getType()
     {
         return Type;
     }
    
}
