package org.as.Model;

import static org.junit.Assert.*;

import java.util.List;

import org.as.entities.User;
import org.as.metier.IUserMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteUserTest {

	private ClassPathXmlApplicationContext context;
	private IUserMetier userMetier;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		userMetier = (IUserMetier)context.getBean("userMetier");
	}

	@Test
	public void test() {
		List<User> u1 = userMetier.getAllUser();
		User user = u1.get(0);
		userMetier.deleteUser(user.getId());
		List<User> u2 = userMetier.getAllUser();
		assertTrue(u1.size()-1 == u2.size() && userMetier.getUserById(user.getId()) == null);
	}

}
