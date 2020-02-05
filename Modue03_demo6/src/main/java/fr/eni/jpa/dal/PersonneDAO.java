package fr.eni.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.User;

public class PersonneDAO {

	public void add(User user) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(user);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update(User user) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(user);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void delete(User user) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(user);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public User findById(int id) {
		return DAOUtil.getEm().find(User.class, id);
	}
	
	public List<User> findAll(){
		String requete = "select Object(u) from User u";
		
		return DAOUtil.getEm().createQuery(requete, User.class).getResultList();
	}
}
