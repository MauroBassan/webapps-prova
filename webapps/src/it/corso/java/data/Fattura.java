package it.corso.java.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fattura")
@SecondaryTable(name = "cliente", pkJoinColumns = {@PrimaryKeyJoinColumn(name = "id_cliente" )})

public class Fattura  implements Serializable {
	
	private Integer id;
	private String numeroFattura;
	private Date dataFattura;
	
	private Cliente cliente;
	
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name = "id_fattura")
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
	 * @return the numeroFattura
	 */
	@Column(name = "numero")
	public String getNumeroFattura() {
		return numeroFattura;
	}
	/**
	 * @param numeroFattura the numeroFattura to set
	 */
	public void setNumeroFattura(String numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	/**
	 * @return the dataFattura
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fattura")
	public Date getDataFattura() {
		return dataFattura;
	}
	/**
	 * @param dataFattura the dataFattura to set
	 */
	public void setDataFattura(Date dataFattura) {
		this.dataFattura = dataFattura;
	}
	/**
	 * @return the cliente
	 */
	@Embedded
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
