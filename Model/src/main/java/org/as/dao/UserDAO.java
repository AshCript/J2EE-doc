package org.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.as.entities.User;

public class UserDAO implements IUserDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User getUserById(int id) {
		return em.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		Query req = em.createQuery("select u from User u");
		return req.getResultList();
	}

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		User user = this.getUserById(id);
		
		if(user != null) {
			em.remove(user);			
		}else {
			System.out.println("User with id " + id + " not found");
		}
	}

}
