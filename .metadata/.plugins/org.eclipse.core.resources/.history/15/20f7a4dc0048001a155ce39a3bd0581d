package fr.eni.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="PERSONNE_MTO")
public class User implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	
	@ManyToOne
	private Civilite civilite;
	
	public User() {
	}

	public User(String nom, String prenom, Civilite civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + "]";
	}

}
