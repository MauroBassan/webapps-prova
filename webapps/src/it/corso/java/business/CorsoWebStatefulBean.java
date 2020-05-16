package it.corso.java.business;

import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class CorsoWebStatefulBean
 */
@Stateful
public class CorsoWebStatefulBean implements CorsoWebStatefulBeanLocal{
	
	private int contatore;
	
    /**
     * Default constructor. 
     */
    public CorsoWebStatefulBean() {
       
    }
    
    public void incrementa(int c) {
    	setContatore(getContatore()+ c);
    }

	/**
	 * @return the contatore
	 */
	public int getContatore() {
		return contatore;
	}

	/**
	 * @param contatore the contatore to set
	 */
	public void setContatore(int contatore) {
		this.contatore = contatore;
	}

	@Remove
	public void chiudiConnessione() {
		
	}
    
}
