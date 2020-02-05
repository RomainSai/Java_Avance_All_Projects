package fr.eni.jpa.entity;

import java.util.List;

import fr.eni.jpa.dal.CiviliteDAO;
import fr.eni.jpa.dal.DAOUtil;

public class TestCivilite {
	public static void main(String[] args) {
		Civilite m  =new Civilite("M", "Monsieur");
		Civilite mme  =new Civilite("Mme", "Madame");
		
		CiviliteDAO cdao = new CiviliteDAO();
		
		try {
			cdao.add(mme);
			cdao.add(m);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Les civilités en base : ");
		List<Civilite> liste = cdao.findAll();
		System.out.println(liste);
	
		DAOUtil.close();
	}
}
