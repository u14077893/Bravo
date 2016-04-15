package za.ac.cs.teambravo.publications.requestandresponses;

import java.util.ArrayList;
<<<<<<< HEAD
import za.ac.cs.teambravo.publications.entities.PublicationEntity;
=======

import za.ac.cs.teambravo.publications.entities.Publication;

>>>>>>> 4049fcc9c967af92f865119b8ad8ba284b52459d

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hlengekile
 */
public class GetPublicationsForGroupResponse implements PublicationResponse
{
    private ArrayList<PublicationEntity> publications;

    
    public GetPublicationsForGroupResponse() 
    {
    }
  
    /**
     *
     * @param publications
     */
    public GetPublicationsForGroupResponse(ArrayList<PublicationEntity> publications) 
    {
        this.publications = publications;
    }

    /**
     *
     * @return
     */
    public ArrayList<PublicationEntity> getPublications() 
    {
        return publications;
    }

    /**
     *
     * @param publications
     */
    public void setPublications(ArrayList<PublicationEntity> publications) 
    {
        this.publications = publications;
    }
}
