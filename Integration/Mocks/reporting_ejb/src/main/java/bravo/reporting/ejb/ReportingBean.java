/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bravo.reporting.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Dillon
 */
@Stateless
@LocalBean
public class ReportingBean {
    public ReportingBean() {
        
    }
    
    public String getReport() {
        return "Report info";
    }
}
