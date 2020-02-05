package fr.eni.jpa.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.Address;

public class AddressDAO {
	public void add(Address address) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.persist(address);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update(Address address) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.merge(address);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void delete(Address address) throws Exception {
		EntityManager em = DAOUtil.getEm();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		try {
			em.remove(address);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public Address findById(int id) {
		return DAOUtil.getEm().find(Address.class, id);
	}
	
	public List<Address> findAll(){
		String requete = "select Object(u) from Address u";
		
		return DAOUtil.getEm().createQuery(requete, Address.class).getResultList();
	}
}
