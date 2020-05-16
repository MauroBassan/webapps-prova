package it.corso.java.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {

	private Long id;
	private String nome;
	private String cognome;
	private int anni;
	
	private Account account;
	
	//private List<Indirizzo> indirizzi;
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="id_persona")
	//GenerateValue come segnato di seguito, forza il container ad usare l'auto increment per questo campo della tabella
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	@Column(name="nome", nullable=false, length = 100 )
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
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}
	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * @return the anni
	 */
	@Column(name="anni")
	public int getAnni() {
		return anni;
	}
	/**
	 * @param anni the anni to set
	 */
	public void setAnni(int anni) {
		this.anni = anni;
	}
	/**
	 * @return the account
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_account")
	public Account getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
