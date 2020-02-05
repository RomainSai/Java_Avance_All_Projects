package fr.eni.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@SuppressWarnings("serial")
@Table (name="CIVILITE_MTO")
public class Civilite implements Serializable {

	@Id
	private String cle;
	private String civilite;
	
	public Civilite() {
	}

	public Civilite(String cle, String civilite) {
		super();		this.cle = cle;
		this.civilite = civilite;
	}
	
	public String getCle() {
		return cle;
	}
	
	public void setCle(String cle) {
		this.cle = cle;
	}
	
	public String getCivilite() {
		return civilite;
	}
	
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	@Override
	public String toString() {
		return "Civilite [cle=" + cle + ", civilite=" + civilite + "]";
	}
}
