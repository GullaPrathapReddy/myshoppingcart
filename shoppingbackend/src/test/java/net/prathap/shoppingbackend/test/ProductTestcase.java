package net.prathap.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.prathap.shoppingbackend.dao.ProductDAO;
import net.prathap.shoppingbackend.dto.Product;

public class ProductTestcase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO dao;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("net.prathap.shoppingbackend.config");
		context.refresh();
		dao=context.getBean("productDAO",ProductDAO.class);
		
	}
	@Test
	public void test() {
		/*//new Product
		Product product=new Product();
		//set the values
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		*/
		/*assertEquals("SuccessFully added new Product", true, dao.add(product));*/
		
		
		Product product1=new Product();
		//get and Update and delete
		product1=dao.getProduct(6);
		System.out.println(product1.getId()+"--"+product1.getName());
		product1.setName("OPPO S53 Selfie");
		product1.setQuantity(10);
		product1.setUnitPrice(88000.00);
		/*assertEquals("SuccessFully updated Product", true, dao.update(product1));
		//delete
		assertEquals("SuccessFully added new Product", true, dao.delete(product1));
		//total products
		assertEquals("SuccessFully added new Product", 6, dao.listProduct().size());
		*/
	}
	
	@Test
	public void IsActivetest() {
		assertEquals("Expected List OF IsActive Products ", 5,dao.listActiveProducts().size());
		assertEquals("Expected List OF IsActive Products By Catagory ", 2,dao.listActiveProductsByCategory(1));
		assertEquals("Expected List OF IsActive Products By Count ", 5,dao.getLatestActiveProducts(5));
	}
	
	
}
