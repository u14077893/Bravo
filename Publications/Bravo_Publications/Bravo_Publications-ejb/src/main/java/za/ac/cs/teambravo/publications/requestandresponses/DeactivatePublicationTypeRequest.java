/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

/**
 *
 * @author vuyani
 */
public class DeactivatePublicationTypeRequest {
    String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public DeactivatePublicationTypeRequest(String typeName) {
        this.typeName = typeName;
    }
}
