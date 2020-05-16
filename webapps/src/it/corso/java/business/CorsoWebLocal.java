package it.corso.java.business;

import javax.ejb.Local;

@Local
public interface CorsoWebLocal  extends CorsoWeb{
	public void salvaFattura();

}
