package za.ac.cs.teambravo.publications.requestandresponses;

import java.util.ArrayList;
<<<<<<< HEAD
import za.ac.cs.teambravo.publications.base.Publication;
=======
import za.ac.cs.teambravo.Publication;
>>>>>>> b710192f94362d196b837f66ffb08a179b0bb84a

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hlengekile
 */
public class GetPublicationsForPersonResponse implements PublicationResponse
{
    private ArrayList<Publication> publications;

    public GetPublicationsForPersonResponse() 
    {
    }
  
    public GetPublicationsForPersonResponse(ArrayList<Publication> publications) 
    {
        this.publications = publications;
    }

    public ArrayList<Publication> getPublications() 
    {
        return publications;
    }

    public void setPublications(ArrayList<Publication> publications) 
    {
        this.publications = publications;
    }
   
}
