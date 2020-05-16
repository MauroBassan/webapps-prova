package it.corso.java.business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CorsoWebStatefulBean
 */

@Local
public interface CorsoWebStatefulBeanLocal {
	
    
    public void incrementa(int c);

    public int getContatore();
   
    public void chiudiConnessione();
    
}
