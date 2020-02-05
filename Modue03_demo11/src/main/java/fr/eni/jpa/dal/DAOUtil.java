package fr.eni.jpa.dal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gestion de la configuration de EntityManagerFactory
 * @author rsaillou2018
 * -- Parce qu'on est dans un mode client lourd
 * -- On va se permettre d'avoir un singleton et gérer les traiements en statique.
 *
 */
public class DAOUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("Mysql_UP");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEm() {
		return em;
	}
	
	public static void close() {
		if (em != null) {
			em.close();
		}
		if (emf != null) {
			emf.close();
		}
	}
}
