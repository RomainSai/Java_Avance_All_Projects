package fr.eni.jpa.entity;

import java.util.List;

import fr.eni.jpa.dal.DAOUtil;
import fr.eni.jpa.dal.PaysDAO;
import fr.eni.jpa.dal.PersonneDAO;

public class TestUser {
	
	public static void main(String[] args) {
		
		PersonneDAO pdao = new PersonneDAO();
		PaysDAO paysdao = new PaysDAO();
		
		try {
			Pays fr = getPays("fr", "France");
			Pays it = getPays("it", "Italie");
			Pays gb = getPays("gb", "Grande Bretagne");
			Pays gr = getPays("gr", "Grèce");
			Pays es = getPays("es", "Espagne");

			
			User p1 = new User("Leblond", "Annie");
			User p2 = new User("Lebrun", "Sophie");

			p1.ajouerPaysVisite(fr);
			p2.ajouerPaysVisite(it);
			p1.ajouerPaysVisite(es);
			
			p2.ajouerPaysVisite(fr);
			p2.ajouerPaysVisite(gr);
			p2.ajouerPaysVisite(gb);
			
			//insertion en BDD
			pdao.add(p1);
			pdao.add(p2);

			System.out.println("Liste des personnes :");
			List<User> listeU = pdao.findAll();
			System.out.println(listeU);
			
			p2.supprimerPaysVisite(gb);
			Pays po = getPays("po", "Portugal");
			p2.ajouerPaysVisite(po);
			pdao.update(p2);
			listeU = pdao.findAll();
			System.out.println(listeU);

			System.out.println("Supression de p1");
			pdao.delete(p1);
			listeU = pdao.findAll();
			System.out.println(listeU);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DAOUtil.close();
	}
	
	private static Pays	getPays(String cle, String libelle) throws Exception {
		PaysDAO paysdao = new PaysDAO();
		Pays p = paysdao.findById(cle);
		if (p == null) {
			p = new Pays(cle, libelle);
			paysdao.add(p);
		}
		return p;
	}
}
