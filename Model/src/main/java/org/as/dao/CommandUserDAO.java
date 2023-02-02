package org.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.as.entities.CommandUser;

public class CommandUserDAO implements ICommandUserDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public CommandUser getCommandUserById(int id) {
		return em.find(CommandUser.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommandUser> getAllCommandUser() {
		Query req = em.createQuery("select cu from CommandUser cu");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommandUser> getCommandUserByUser(int userId) {
		Query req = em.createQuery("select cu from CommandUser cu where cu.userId = :userId");
		req.setParameter("userId", userId);
		return req.getResultList();
	}

	@Override
	public void updateCommandUser(CommandUser commandUser) {
		em.merge(commandUser);
	}

	@Override
	public void deleteCommandUser(int id) {
		CommandUser commandUser = this.getCommandUserById(id);
		
		if(commandUser != null) {
			em.remove(commandUser);
		}else {
			System.out.println("CommandUserMetier with ID " + id + " doesn't exist.");
		}
	}

	@Override
	public void addCommandUser(CommandUser commandUser) {
		em.persist(commandUser);
	}
}