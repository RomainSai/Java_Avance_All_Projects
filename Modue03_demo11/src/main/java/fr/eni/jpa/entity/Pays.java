package fr.eni.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="PAYS_MTM")
public class Pays {

	@Id
	private String cle;
	private String libelle;
	
	public Pays(String cle, String libelle) {
		super();
		this.cle = cle;
		this.libelle = libelle;
	}
	
	public Pays() {
		super();
	}
	
	public String getCle() {
		return cle;
	}
	
	public void setCle(String cle) {
		this.cle = cle;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	@Override
	public String toString() {
		return "Pays [cle=" + cle + ", libelle=" + libelle + "]";
	}
	
}
