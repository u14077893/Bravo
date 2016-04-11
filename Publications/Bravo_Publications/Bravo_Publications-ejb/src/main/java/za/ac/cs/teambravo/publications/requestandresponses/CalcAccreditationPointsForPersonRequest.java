/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.entities.Person;

/**
 *
 * @author Hlengekile
 */
public class CalcAccreditationPointsForPersonRequest implements PublicationRequest
{
    private Person forWho;

    public CalcAccreditationPointsForPersonRequest(Person forWho) 
    {
        this.forWho  = forWho;
    }

    public Person getForWho() {
        return forWho;
    }

    public void setForWho(Person forWho) {
        this.forWho = forWho;
    }

}