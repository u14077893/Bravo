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
public class PublicationsTypeMock implements PublicationTypes{
   
    /**
     *
     * @param addPublicationTypeRequest
     * @return response
     */
    public AddPublicationTypeResponseMock addPublicationType(AddPublicationTypeRequestMock addPublicationTypeRequest)
    {
        AddPublicationTypeResponseMock response = new AddPublicationTypeResponseMock();
        response.setType(addPublicationTypeRequest.getType());
        return response;
    }
    
//    public ModifyPublicationTypeResponseMock modifyPublicationType(ModifyPublicationTypeRequestMock modifyPublicationTypeRequest)
//    {
//       return new ModifyPublicationTypeResponseMock();
//    }
}
