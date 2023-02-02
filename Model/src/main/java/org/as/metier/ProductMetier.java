package org.as.metier;

import java.util.List;

import org.as.dao.IProductDAO;
import org.as.entities.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductMetier implements IProductMetier{

	private IProductDAO productDao;
	
	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}

	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

}
