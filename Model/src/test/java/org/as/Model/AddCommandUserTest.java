package org.as.Model;

import java.util.List;

import org.as.entities.Command;
import org.as.entities.CommandUser;
import org.as.entities.Product;
import org.as.metier.ICommandMetier;
import org.as.metier.ICommandUserMetier;
import org.as.metier.IProductMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AddCommandUserTest extends TestCase {

	private ClassPathXmlApplicationContext context;
	private ICommandUserMetier commandUserMetier;
	private ICommandMetier commandMetier;
	private IProductMetier productMetier;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		commandUserMetier = (ICommandUserMetier)context.getBean("commandUserMetier");
		commandMetier = (ICommandMetier)context.getBean("commandMetier");
		productMetier = (IProductMetier) context.getBean("productMetier");
	}

	@Test
	public void test() {
		List<CommandUser> cu1 = commandUserMetier.getAllCommandUser();
		List<Command> commands = commandMetier.getAllCommand();
		List<Product> products = productMetier.getAllProduct();
		Command c1 = commands.get(0);
		Command c2 = commands.get(1);
		Product p1 = products.get(0);
		Product p2 = products.get(1);
		
		commandUserMetier.addCommandUser(new CommandUser(c1, p1, 3));
		commandUserMetier.addCommandUser(new CommandUser(c1, p2, 1));
		commandUserMetier.addCommandUser(new CommandUser(c2, p1, 4));
		commandUserMetier.addCommandUser(new CommandUser(c2, p2, 2));
		List<CommandUser> cu2 = commandUserMetier.getAllCommandUser();
		assertTrue(cu1.size()+4 == cu2.size());
	}
}
