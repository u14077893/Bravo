/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cs.teambravo.publications.base;

<<<<<<< HEAD
import java.util.List;
import za.ac.cs.teambravo.publications.base.PublicationTypeState;
=======
import java.util.ArrayList;
>>>>>>> origin/master

/**
 *
 * @author Kudzai
 */
public class PublicationType {
    String typeName;
    PublicationTypeState typeState;

<<<<<<< HEAD
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public PublicationTypeState getTypeState() {
        return typeState;
    }

    public void setTypeStates(PublicationTypeState typeState) {
        this.typeState = typeState;
    }

    public PublicationType(String typeName, PublicationTypeState typeStates) {
        this.typeName = typeName;
        this.typeState = typeStates;
    }

 

  
    public void addStateEntry()
    {
        
    }
=======
public class PublicationType 
{
<<<<<<< HEAD
=======
   
>>>>>>> b710192f94362d196b837f66ffb08a179b0bb84a
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

    
>>>>>>> origin/master
}
