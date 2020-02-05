package fr.eni.jpa.entity;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestUser {
	
	public static void main(String[] args) {
		//création de la BDD
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		//Création d'une instance d'user
		//quand on utilise gregorian calendar, le mois commence à 0
		PersonnePK p1 = new PersonnePK("Legrand", "Lucie");
		User ul = new User(p1, "toto", "pass", new GregorianCalendar(2000,05,10), 19);
		
		PersonnePK p2 = new PersonnePK("Legrand", "Eglantine");
		User u2 = new User(p2, "tata", "pass", new GregorianCalendar(2000,05,10), 19);
		
		em.getTransaction().begin();
		try {
			//on persist en BDD, .persist = insert | .merge = update
			em.persist(ul);
			em.persist(u2);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(); //Mode Dev
			em.getTransaction().rollback();
		}
		
		//PLSQL -- langage de requete orienté objet
		String requete = "from User u";
		List<User> liste = em.createQuery(requete, User.class).getResultList();
		
		System.out.println("Liste des Utilisateurs : ");
		System.out.println(liste);
		
		PersonnePK pk = new PersonnePK("Legrand", "Lucie");
		User p = em.find(User.class, pk);
		System.out.println("Personne recherchée :" + p);
		
		em.close();
		emf.close();
	}

}
