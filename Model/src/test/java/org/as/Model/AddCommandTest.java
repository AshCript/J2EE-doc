package org.as.Model;


import java.util.Date;
import java.util.List;

import org.as.entities.Command;
import org.as.entities.User;
import org.as.metier.ICommandMetier;
import org.as.metier.IUserMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AddCommandTest extends TestCase {

	private ClassPathXmlApplicationContext context;
	private ICommandMetier commandMetier;
	private IUserMetier userMetier;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		commandMetier = (ICommandMetier)context.getBean("commandMetier");
		userMetier = (IUserMetier)context.getBean("userMetier");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		List<Command> c1 = commandMetier.getAllCommand();
		List<User> users = userMetier.getAllUser();
		User u1 = users.get(users.size() - 1);
		User u2 = users.get(users.size() - 2);
		commandMetier.addCommand(new Command(u1, new Date("02/02/2023")));
		commandMetier.addCommand(new Command(u2, new Date("02/01/2023")));
		List<Command> c2 = commandMetier.getAllCommand();
		assertTrue(c1.size()+2 == c2.size());
	}
}
