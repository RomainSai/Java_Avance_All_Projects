package fr.eni.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="AdresseOTMBi")
public class Address  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String codepostal;
	private String ville;
	
	@ManyToOne (cascade= {CascadeType.MERGE, CascadeType.PERSIST})
	private User user;

	public Address( String codepostal, String ville) {
		this.codepostal = codepostal;
		this.ville = ville;
	}
	
	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", codepostal=" + codepostal + ", ville=" + ville + "]";
	}
	
}