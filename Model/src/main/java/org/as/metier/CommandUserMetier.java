package org.as.metier;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.as.dao.ICommandUserDAO;
import org.as.entities.Command;
import org.as.entities.CommandUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandUserMetier implements ICommandUserMetier{
	
	ICommandUserDAO commandUserDao;
	
	public void setCommandUserDao(ICommandUserDAO commandUserDao) {
		this.commandUserDao = commandUserDao;
	}

	@Override
	public CommandUser getCommandUserById(int id) {
		return commandUserDao.getCommandUserById(id);
	}

	@Override
	public List<CommandUser> getAllCommandUser() {
		return commandUserDao.getAllCommandUser();
	}

	@Override
	public List<CommandUser> getCommandUserByUser(int userId) {
		return commandUserDao.getCommandUserByUser(userId);
	}

	@Override
	public void updateCommandUser(CommandUser commandUser) {
		commandUserDao.updateCommandUser(commandUser);
	}

	@Override
	public void deleteCommandUser(int id) {
		commandUserDao.deleteCommandUser(id);
	}

	@Override
	public void addCommandUser(CommandUser commandUser) {
		commandUserDao.addCommandUser(commandUser);
	}
}
