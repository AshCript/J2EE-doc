package org.as.Model;


import java.util.Date;
import java.util.List;

import org.as.entities.User;
import org.as.metier.IUserMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AddUserTest extends TestCase {

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
		List<User> u1 = userMetier.getAllUser();
		userMetier.addUser(new User("Rakoto",new Date("01/12/1995") , true, "Antananarivo", "Adresse de Rakoto", "0340612345"));
		userMetier.addUser(new User("Rabe",new Date("12/23/1993") , true, "Toamasina", "Adresse de Rabe", "0325493847"));
		userMetier.addUser(new User("Rasoa",new Date("07/01/1992") , true, "Fianarantsoa", "Adresse de Rasoa", "0335511233"));
		List<User> u2 = userMetier.getAllUser();
		assertTrue(u1.size()+3 == u2.size());
	}
}
