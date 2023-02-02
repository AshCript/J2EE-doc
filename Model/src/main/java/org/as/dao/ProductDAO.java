package org.as.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.as.entities.Product;

public class ProductDAO implements IProductDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Product getProductById(int id) {
		return em.find(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		Query req = em.createQuery("select p from Product p");
		return req.getResultList();
	}

	@Override
	public void addProduct(Product product) {
		em.persist(product);
	}

	@Override
	public void updateProduct(Product product) {
		em.merge(product);
	}

	@Override
	public void deleteProduct(int id) {
		Product product = this.getProductById(id);
		
		if(product != null) {
			em.remove(product);
		}else {
			System.out.println("Product with ID " + id + " doesn't exist.");
		}
	}

}
