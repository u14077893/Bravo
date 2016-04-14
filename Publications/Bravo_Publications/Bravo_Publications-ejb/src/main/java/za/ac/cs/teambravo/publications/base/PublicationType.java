/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.base;


import java.util.List;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;

import java.util.ArrayList;


/**
 *
 * @author Kudzai
 */

//package za.ac.cs.teambravo.publications.publications;


    public class PublicationType
{

    String name;
    ArrayList<PublicationTypeState> typeStates;

    public PublicationType(String name, ArrayList<PublicationTypeState> typeStates) {
        this.name = name;
        this.typeStates = typeStates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<PublicationTypeState> getTypeStates() {
        return typeStates;
    }

    public void setTypeStates(ArrayList<PublicationTypeState> typeStates) {
        this.typeStates = typeStates;
    }
    
    public String getPublicationType(){
        return name;
    }
    public void setPublicationType(String _name)
    {
        name = _name;
    }


}
