package fr.eni.jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table (name="UserOTMBi")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	
	//association -- bidirectionnelle -- composition
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true, mappedBy="user")
	private List<Address> listeAddresses;
	
	//Permet de g�rer la mise � jour bidirectionelle
	private void bidirectionel() {
		for (Address address : listeAddresses) {
			address.setUser(this);
		}
	}
	
	public User() {
		setListeAddresses(null);
	}
	
	public User(String nom, String prenom, List<Address> listeAddresses) {
		this.nom = nom;
		this.prenom = prenom;
		this.listeAddresses = listeAddresses;
		bidirectionel();
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
	
	public List<Address> getListeAddresses() {
		return listeAddresses;
	}

	public void setListeAddresses(List<Address> listeAddresses) {
		this.listeAddresses = listeAddresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", listeAddresses=" + listeAddresses + "]";
	}

}
