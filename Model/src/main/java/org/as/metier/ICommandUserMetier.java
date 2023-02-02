package org.as.metier;

import java.util.List;

import org.as.entities.Command;
import org.as.entities.CommandUser;

public interface ICommandUserMetier {
	CommandUser getCommandUserById(int id);
	List<CommandUser> getAllCommandUser();
	List<CommandUser> getCommandUserByUser(int userId);
	
	void addCommandUser(CommandUser commandUser);
	void updateCommandUser(CommandUser commandUser);
	void deleteCommandUser(int id);
}
