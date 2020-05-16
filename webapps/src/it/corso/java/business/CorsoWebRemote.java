package it.corso.java.business;

import javax.ejb.Remote;

@Remote
public interface CorsoWebRemote extends CorsoWeb {
	
	public void collegati();

}
