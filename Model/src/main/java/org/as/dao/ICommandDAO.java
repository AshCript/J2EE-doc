package org.as.dao;

import java.util.Date;
import java.util.List;

import org.as.entities.Command;

public interface ICommandDAO {
	Command getCommandById(int id);
	List<Command> getAllCommand();
	List<Command> getCommandByUser(int userId);
	List<Command> getCommandByDate(Date date);
	void addCommand(Command command);
	void updateCommand(Command command);
	void deleteCommand(int id);
}
