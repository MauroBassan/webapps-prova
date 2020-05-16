package it.corso.java.business.rest;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Session Bean implementation class FatturaServiceBean
 */
@Stateless
@Path(value="/fattura")
public class FatturaServiceBean {

    /**
     * Default constructor. 
     * @return 
     */
    public FatturaServiceBean() {
    
    }   
    	
    @GET
    @Produces(value="text/plain")
    public String generaprossimoNumero() {
    	return "12345";
    }
    
    @GET
    @Produces(value="text/plain")
    @Path(value="anno")
    public String generaAnno() {
    	Date d = new Date();
    	return d.toString();
    }
    
    
}
