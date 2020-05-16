package it.corso.java.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Cliente {
	
	private String nome;
	private String cognome;
	
	/**
	 * @return the nome
	 */
	@Column(name = "nome", table = "cliente")
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the cognome
	 */
	@Column(name = "cognome", table = "cliente")
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

}
