package fr.eni.jpa.main;

import java.util.List;

import fr.eni.jpa.dal.AddressDAO;
import fr.eni.jpa.dal.DAOUtil;
import fr.eni.jpa.dal.PersonneDAO;
import fr.eni.jpa.entity.Address;
import fr.eni.jpa.entity.User;

public class TestUser {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//nouvelle instance de Adresse (*2) et d'user (*2)
		Address a1 = new Address("44000", "Nantes");
		Address a2 = new Address("35000", "Rennes");
		User u1 = new User("Lebrun", "Jeanne", a1);
		User u2 = new User("Leblond", "Annie", a2);
		
		//nouvelle instance PersonneDAO vide
		PersonneDAO pdao = new PersonneDAO();
		AddressDAO adao = new AddressDAO();
		try {
			pdao.add(u1);
			pdao.add(u2);
			
			List<User> liste = pdao.findAll();
			System.out.println("Les personnes : ");
			System.out.println(liste);
			
			System.out.println("Suppression de "+ a1);
			adao.delete(a1);

			
			System.out.println("Liste des adresses : ");
			List<Address> listeA = adao.findAll();
			System.out.println(listeA);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		DAOUtil.close();
		
	}
	
}
