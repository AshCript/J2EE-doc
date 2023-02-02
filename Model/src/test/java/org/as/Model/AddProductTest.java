package org.as.Model;


import java.util.Date;
import java.util.List;

import org.as.entities.FoodProduct;
import org.as.entities.MaterialProduct;
import org.as.entities.Product;
import org.as.metier.IProductMetier;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class AddProductTest extends TestCase {

	private ClassPathXmlApplicationContext context;
	private IProductMetier productMetier;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		productMetier = (IProductMetier)context.getBean("productMetier");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		List<Product> p1 = productMetier.getAllProduct();
		productMetier.addProduct(new MaterialProduct("Cahier", 2f, new Date(), false, false));
		productMetier.addProduct(new MaterialProduct("Coûteau", 1.5f, new Date(), true, false));
		productMetier.addProduct(new FoodProduct("Pêche", 0.25f , new Date(), new Date("02/02/2023")));
		List<Product> p2 = productMetier.getAllProduct();
		assertTrue(p1.size()+3 == p2.size());
	}
}
