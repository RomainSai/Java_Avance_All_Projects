package fr.eni.jpa.entity;

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
		User ul = new User(1, "java", "avance");
		
		em.getTransaction().begin();
		try {
			//on persist en BDD
			em.persist(ul);
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
		
		em.close();
		emf.close();
	}

}
