package org.as.metier;

import java.util.List;

import org.as.entities.Product;

public interface IProductMetier {
	Product getProductById(int id);
	List<Product> getAllProduct();
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int id);
}
