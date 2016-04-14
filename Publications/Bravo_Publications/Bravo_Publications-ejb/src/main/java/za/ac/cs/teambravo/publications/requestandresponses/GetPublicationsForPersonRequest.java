package za.ac.cs.teambravo.publications.requestandresponses;

import za.ac.cs.teambravo.publications.base.Period;
import za.ac.cs.teambravo.publications.base.PersonMock;
import za.ac.cs.teambravo.publications.base.PublicationConfidenceLevel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hlengekile
 */

public class GetPublicationsForPersonRequest implements PublicationRequest
{
    private PersonMock requester;
    
    private Period timePeriod;
    
    private PublicationConfidenceLevel pubConfidence;

    public GetPublicationsForPersonRequest() 
    {
    }

    public GetPublicationsForPersonRequest(PersonMock requester, PublicationConfidenceLevel pubConfidence) 
    {
        this.requester = requester;
        this.pubConfidence = pubConfidence;
    }
    
    public GetPublicationsForPersonRequest(PersonMock requester, PublicationConfidenceLevel pubConfidence, Period timePeriod)
    {
        this.requester = requester;
        this.timePeriod = timePeriod;
        this.pubConfidence = pubConfidence;
    }

    public PersonMock getRequester() {
        return requester;
    }

    public void setRequester(PersonMock requester) {
        this.requester = requester;
    }

    public Period getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Period timePeriod) {
        this.timePeriod = timePeriod;
    }

    public PublicationConfidenceLevel getPubConfidence() {
        return pubConfidence;
    }

    public void setPubConfidence(PublicationConfidenceLevel pubConfidence) {
        this.pubConfidence = pubConfidence;
    }
    
    public boolean hasTimePeriod()
    {
        if(timePeriod != null)
        {
           return true;
        }
        else
        {
            return false;
        }
    }
 
}
