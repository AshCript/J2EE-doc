package org.as.metier;

import java.util.List;

import org.as.dao.IUserDAO;
import org.as.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserMetier implements IUserMetier{
	
	private IUserDAO userDao;

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

}
