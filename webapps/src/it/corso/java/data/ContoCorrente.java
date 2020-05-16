package it.corso.java.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "conto_corrente")
public class ContoCorrente {

	private Integer id;
	private String numero;
	
	private Utente utenteConto;
	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conto_corrente")
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the numero
	 */
	@Column(name = "numero_conto")
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the utente
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_utente")
	public Utente getUtenteConto() {
		return utenteConto;
	}
	/**
	 * @param utente the utente to set
	 */
	public void setUtenteConto(Utente utente) {
		this.utenteConto = utente;
	}
	
	
}
