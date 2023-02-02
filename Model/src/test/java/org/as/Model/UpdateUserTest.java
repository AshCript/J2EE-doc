package org.as.Model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.as.entities.User;
import org.as.metier.IUserMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UpdateUserTest {

	private ClassPathXmlApplicationContext context;
	private IUserMetier userMetier;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		userMetier = (IUserMetier)context.getBean("userMetier");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		List<User> u = userMetier.getAllUser();
		User user = u.get(1);
		User user2 = u.get(1);
		user.setName("Miora");
		user.setBorn(new Date("03/06/2000"));
		user.setMale(false);
		user.setCity("Mahajanga");
		user.setAddress("Adresse de Miora");
		user.setPhone("0324354376");
		userMetier.updateUser(user);
		assertTrue(user.getId() == user2.getId() && user == user2);
	}

}
