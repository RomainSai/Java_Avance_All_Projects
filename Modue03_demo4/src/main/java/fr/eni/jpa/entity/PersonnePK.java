package fr.eni.jpa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


/**
 * La classe pour représenter la clé primaire
 * @author rsaillou2018
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class PersonnePK implements Serializable {
	
	private String nom;
	private String prenom;
	
	public PersonnePK() {
	}

	public PersonnePK(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "PersonnePK [nom=" + nom + ", prenom=" + prenom + "]";
	}
}
