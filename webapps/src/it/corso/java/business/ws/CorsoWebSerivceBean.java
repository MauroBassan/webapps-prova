package it.corso.java.business.ws;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Session Bean implementation class CorsoWebSerivceBean
 */
@Stateless
@WebService(serviceName="corsoweb")
public class CorsoWebSerivceBean {

    /**
     * Default constructor. 
     */
    public CorsoWebSerivceBean() {
        // TODO Auto-generated constructor stub
    }
    
    @WebMethod(operationName = "salutami")
    public String saluta(String nome, String cognome) {
    	
    	return "ciao "+ nome +" " + cognome;
    }

}
