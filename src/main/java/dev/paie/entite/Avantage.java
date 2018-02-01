package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Avantage")
public class Avantage {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name="code")
	private String code;
	@Column(name="nom")
	private String nom;
	@Column(name="montant")
	private BigDecimal montant;

	
	
	
	public Avantage() {
	
		// TODO Auto-generated constructor stub
	}
	


	public Avantage( String code, String nom, BigDecimal montant) {

		this.code = code;
		this.nom = nom;
		this.montant = montant;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
