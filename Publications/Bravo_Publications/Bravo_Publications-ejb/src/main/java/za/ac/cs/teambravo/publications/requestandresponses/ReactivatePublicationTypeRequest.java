/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.PublicationType;

/**
 *
 * @author Kudzai
 */
public class ReactivatePublicationTypeRequest {
    String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public ReactivatePublicationTypeRequest(String typeName) {
        this.typeName = typeName;
    }
}
