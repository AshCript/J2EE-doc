package org.as.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.as.entities.Command;

public class CommandDAO implements ICommandDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Command getCommandById(int id) {
		return em.find(Command.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> getAllCommand() {
		Query req = em.createQuery("select c from Command c");
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> getCommandByUser(int userId) {
		Query req = em.createQuery("select c from Command c where c.userId = :userId");
		req.setParameter("userId", userId);
		return req.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Command> getCommandByDate(Date dateCommand) {
		Query req = em.createQuery("select c from Command c where c.dateCommand = :dateCommand");
		req.setParameter("dateCommand", dateCommand);
		return req.getResultList();
	}

	@Override
	public void updateCommand(Command command) {
		em.merge(command);
	}

	@Override
	public void deleteCommand(int id) {
		Command command = this.getCommandById(id);
		
		if(command != null) {
			em.remove(em);			
		}else {
			System.out.println("Command with ID " + id + " doesn't exist.");
		}
	}

	@Override
	public void addCommand(Command command) {
		em.persist(command);
	}


}
