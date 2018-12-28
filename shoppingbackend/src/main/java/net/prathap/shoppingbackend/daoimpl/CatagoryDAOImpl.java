package net.prathap.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.prathap.shoppingbackend.dao.CatagoryDAO;
import net.prathap.shoppingbackend.dto.Catagory;

@Repository("catagoryDAO")
public class CatagoryDAOImpl implements CatagoryDAO {

	private static List<Catagory> catagories=new ArrayList<Catagory>();
	static {
		
			/*Catagory------1*/
		Catagory cat1=new Catagory();
		cat1.setCatagoryid(1);
		cat1.setCatagoryname("Television");
		cat1.setDescription("This is Television Catagories");
		cat1.setUrl("Yes Not Be done");
		cat1.setActive(true);
		/*Catagory------2*/
		Catagory cat2=new Catagory();
		cat2.setCatagoryid(2);
		cat2.setCatagoryname("Men Fashions");
		cat2.setDescription("This is Men Fashion Catagories");
		cat2.setUrl("Yes Not Be done");
		cat2.setActive(true);
		/*Catagory------3*/
	
		Catagory cat3=new Catagory();
		cat3.setCatagoryid(3);
		cat3.setCatagoryname("Laptop");
		cat3.setDescription("This is Laptop Catagories");
		cat3.setUrl("Yes Not Be done");
		cat3.setActive(true);
		catagories.add(cat1);
		catagories.add(cat2);
		catagories.add(cat3);
	}

	
	public List<Catagory> Sendcatagaries() {
		
		
		return catagories;
	}

}
