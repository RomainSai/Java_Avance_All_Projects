package fr.eni.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table (name="PERSONNE_PK_2")
public class User implements Serializable {
	
	@EmbeddedId
	private PersonnePK personnePK;
	
	@Column (name="LOGIN", length=25)
	private String login;
	
	@Column (name="PWD", length=25)
	private String password;	
	
	@Column (name="BIRTHD", nullable=true)
	@Temporal (TemporalType.DATE) //Imposer le type en base de données
	private Calendar dateNaissance;
	
	//Transient = non enregistré en BDD / pas de création de column age en BDD
	@Transient
	private int age;
	
	public User() {
	}

	
	public User(PersonnePK personnePK, String login, String password, Calendar dateNaissance, int age) {
		this.personnePK = personnePK;
		this.login = login;
		this.password = password;
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

	public PersonnePK getPersonnePK() {
		return personnePK;
	}

	public void setPersonnePK(PersonnePK personnePK) {
		this.personnePK = personnePK;
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
		return "User [personnePK=" + personnePK + ", login=" + login + ", password=" + password + ", dateNaissance="
				+ dateNaissance + ", age=" + age + "]";
	}

}
