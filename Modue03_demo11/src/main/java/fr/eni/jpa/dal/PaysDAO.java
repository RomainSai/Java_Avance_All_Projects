package fr.eni.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.Pays;

public class PaysDAO {

	public void add(Pays pays) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(pays);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update(Pays pays) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(pays);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void delete(Pays pays) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(pays);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public Pays findById(String id) {
		return DAOUtil.getEm().find(Pays.class, id);
	}
	
	public List<Pays> findAll(){
		String requete = "select Object(u) from Pays u";
		
		return DAOUtil.getEm().createQuery(requete, Pays.class).getResultList();
	}
}
