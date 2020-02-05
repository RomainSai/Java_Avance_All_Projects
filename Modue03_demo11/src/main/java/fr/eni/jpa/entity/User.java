package fr.eni.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="PERSONNE_MTM")
public class User implements Serializable {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	
	@ManyToMany
	@JoinTable (name="PersonnePays", 
		joinColumns= {@JoinColumn(name="personneId")},
		inverseJoinColumns= {@JoinColumn(name="paysId")}
	)
	private List<Pays> paysVisites;

	public User() {
		setPaysVisites(null);
	}
	
	public User(String nom, String prenom) {

		this.nom = nom;
		this.prenom = prenom;
		setPaysVisites(null);
	}

	public User(String nom, String prenom, List<Pays> paysVisites) {
		this.nom = nom;
		this.prenom = prenom;
		this.paysVisites = paysVisites;
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

	public List<Pays> getPaysVisites() {
		return paysVisites;
	}

	public void setPaysVisites(List<Pays> paysVisites) {
		this.paysVisites = paysVisites;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", paysVisites=" + paysVisites + "]";
	}
	
	//Eviter d'avoir un null pointeur exception sur la liste
	public void ajouerPaysVisite(Pays p) {
		if (paysVisites == null) {
			paysVisites = new ArrayList<>();
		}
		paysVisites.add(p);
	}

	public void supprimerPaysVisite(Pays p) {
		if (paysVisites != null) {
			paysVisites.remove(p);
		}
	}
}
