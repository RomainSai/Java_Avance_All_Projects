package fr.eni.jpa.entity;

import java.io.Serializable;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table (name="UserOTO")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	
	//association -- unidirectionnelle -- composition
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@Basic (fetch = FetchType.EAGER) -- fonctitonnellement identique au fetch du dessus
	private Address address;
	
	public User() {
	}

	
	public User(String nom, String prenom, Address address) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.address = address;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", address=" + address + "]";
	}	
}
