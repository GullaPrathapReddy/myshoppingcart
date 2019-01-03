package net.prathap.shoppingbackend.dao;

import java.util.List;

import net.prathap.shoppingbackend.dto.Catagory;

public interface CatagoryDAO {

	public List<Catagory> Sendcatagaries();
	public Catagory SendOne(int id);
	public boolean saveCatagoryToDB(Catagory cat);
}
