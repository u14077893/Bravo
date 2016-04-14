package za.ac.cs.teambravo.publications.requestandresponses;

import java.util.ArrayList;
import za.ac.cs.teambravo.publications.entities.PublicationEntity;


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
    private ArrayList<PublicationEntity> publications;

    public GetPublicationsForPersonResponse() 
    {
    }
  
    public GetPublicationsForPersonResponse(ArrayList<PublicationEntity> publications) 
    {
        this.publications = publications;
    }

    public ArrayList<PublicationEntity> getPublications() 
    {
        return publications;
    }

    public void setPublications(ArrayList<PublicationEntity> publications) 
    {
        this.publications = publications;
    }
   
}
