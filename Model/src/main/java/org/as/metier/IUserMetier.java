package org.as.metier;

import java.util.List;

import org.as.entities.User;

public interface IUserMetier {
	User getUserById(int id);
	List<User> getAllUser();
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}
