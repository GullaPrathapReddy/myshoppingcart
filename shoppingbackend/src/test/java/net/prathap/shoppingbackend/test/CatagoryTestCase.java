package net.prathap.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.prathap.shoppingbackend.dao.CatagoryDAO;
import net.prathap.shoppingbackend.dto.Catagory;

public class CatagoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CatagoryDAO Dao;

	private Catagory cat;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.prathap.shoppingbackend.config");
		context.refresh();
		Dao = (CatagoryDAO) context.getBean(CatagoryDAO.class,"catagoryDAO");
		System.out.println(Dao.getClass().getName()+"----Init");
	}

	@Test
	public void TestAddCatagory() {

		 cat = new Catagory();
		cat.setCatagoryname("Laptop");
		cat.setDescription("This is Laptop Catagories");
		cat.setUrl("lap1.jpg");
		cat.setActive(true);
		assertEquals("Successfully Added Catagory inside the Table", true, Dao.saveCatagoryToDB(cat));
	}
}
