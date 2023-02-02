package org.as.dao;

import java.util.List;

import org.as.entities.Product;

public interface IProductDAO {
	Product getProductById(int id);
	List<Product> getAllProduct();
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int id);
}
