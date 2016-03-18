/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.publicationtypes;

/**
 *
 * @author Kudzai
 */
public class AddPublicationTypeResponseMock implements AddPublicationTypeResponse{
     private String Type;
     
     public void setType(String m)
     {
         Type = m;
     }
     
     public String getType()
     {
         return Type;
     }
}
