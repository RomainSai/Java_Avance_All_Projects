package fr.eni.jpa.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@IdClass (PersonnePK.class)
@Table (name="PERSONNE_PK_1")
public class User implements Serializable {
	
	@Id
	private String nom;
	
	@Id
	private String prenom;
	
	@Column (name="LOGIN", length=25)
	private String login;
	
	@Column (name="PWD", length=25)
	private String password;	
	
	@Column (name="BIRTHD", nullable=true)
	@Temporal (TemporalType.DATE) //Imposer le type en base de donn�es
	private Calendar dateNaissance;
	
	//Transient = non enregistr� en BDD / pas de cr�ation de column age en BDD
	@Transient
	private int age;
	
	public User() {
	}

	public User(String login, String password, String nom, String prenom, Calendar dateNaissance, int age) {
		super();
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.age = age;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return "login=" + login + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + sdf.format(dateNaissance.getTime()) + ", age=" + age + "]";
	}
	

}
