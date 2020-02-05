package fr.eni.jpa.entity;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestUser {
	
	public static void main(String[] args) {
		//cr�ation de la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		//Cr�ation d'une instance d'user
		//quand on utilise gregorian calendar, le mois commence � 0
		User ul = new User("me", "toto", "Legrand", "Lucie", new GregorianCalendar(2000,05,22), 19);
		
		em.getTransaction().begin();
		try {
			//on persist en BDD, .persist = insert | .merge = update
			em.persist(ul);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(); //Mode Dev
			em.getTransaction().rollback();
		}
		
		//PLSQL -- langage de requete orient� objet
		String requete = "from User u";
		List<User> liste = em.createQuery(requete, User.class).getResultList();
		
		System.out.println("Liste des Utilisateurs : ");
		System.out.println(liste);
		
		em.close();
		emf.close();
	}

}