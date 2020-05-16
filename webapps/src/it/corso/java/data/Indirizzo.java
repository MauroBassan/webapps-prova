package it.corso.java.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="indirizzo")
public class Indirizzo {
	private Long id;
	
	private String via;
	
	private String città;

	/**
	 * @return the id
	 */
	@Id
	@Column(name="indirizzo")
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
	 * @return the via
	 */
	public String getVia() {
		return via;
	}

	/**
	 * @param via the via to set
	 */
	public void setVia(String via) {
		this.via = via;
	}

	/**
	 * @return the città
	 */
	public String getCittà() {
		return città;
	}

	/**
	 * @param città the città to set
	 */
	public void setCittà(String città) {
		this.città = città;
	}

	
	

}
