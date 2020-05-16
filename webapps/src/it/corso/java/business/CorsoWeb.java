package it.corso.java.business;

/*
 * interfaccia padre che viene estesa da,
 * corsowebremote e
 * corsoweblocal
 */
public interface CorsoWeb {
	
	/*
	 * questi metodi
	 * saranno accessibili
	 * siamo come local che remote
	 */
	public String saluto();
	
	public void stampaFattura();
	
	public void creaConto();
	
	public void creaContoAssociatoAdUnUtente();
}
