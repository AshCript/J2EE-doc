package org.as.dao;

import java.util.List;

import org.as.entities.CommandUser;

public interface ICommandUserDAO {
	CommandUser getCommandUserById(int id);
	List<CommandUser> getAllCommandUser();
	List<CommandUser> getCommandUserByUser(int userId);
	
	void addCommandUser(CommandUser commandUser);
	void updateCommandUser(CommandUser commandUser);
	void deleteCommandUser(int id);
}
