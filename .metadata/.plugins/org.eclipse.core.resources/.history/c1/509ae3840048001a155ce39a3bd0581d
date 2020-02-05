package fr.eni.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.Civilite;

public class CiviliteDAO {

	public void add(Civilite civilite) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(civilite);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update(Civilite civilite) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(civilite);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void delete(Civilite civilite) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(civilite);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public Civilite findById(String id) {
		return DAOUtil.getEm().find(Civilite.class, id);
	}
	
	public List<Civilite> findAll(){
		String requete = "select Object(u) from Civilite u";
		
		return DAOUtil.getEm().createQuery(requete, Civilite.class).getResultList();
	}
}
