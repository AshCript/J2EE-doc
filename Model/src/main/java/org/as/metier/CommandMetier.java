package org.as.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.as.dao.ICommandDAO;
import org.as.entities.Command;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CommandMetier implements ICommandMetier{
	
	ICommandDAO commandDao;

	public void setCommandDao(ICommandDAO commandDao) {
		this.commandDao = commandDao;
	}

	@Override
	public Command getCommandById(int id) {
		return commandDao.getCommandById(id);
	}

	@Override
	public List<Command> getAllCommand() {
		return commandDao.getAllCommand();
	}

	@Override
	public List<Command> getCommandByUser(int userId) {
		return commandDao.getCommandByUser(userId);
	}

	@Override
	public List<Command> getCommandByDate(Date date) {
		return commandDao.getCommandByDate(date);
	}

	@Override
	public void updateCommand(Command command) {
		commandDao.updateCommand(command);
	}

	@Override
	public void deleteCommand(int id) {
		commandDao.deleteCommand(id);
	}

	@Override
	public void addCommand(Command command) {
		commandDao.addCommand(command);
	}


	
}
