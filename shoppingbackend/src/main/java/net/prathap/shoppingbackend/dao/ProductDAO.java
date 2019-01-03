package net.prathap.shoppingbackend.dao;

import java.util.List;

import net.prathap.shoppingbackend.dto.Product;

public interface ProductDAO {

	public List<Product>  listProduct();
	public Product getProduct(int productid);
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	// business methods
		List<Product> listActiveProducts();	
		List<Product> listActiveProductsByCategory(int categoryId);
		List<Product> getLatestActiveProducts(int count);
}
