package net.prathap.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import net.prathap.shoppingbackend.dao.CatagoryDAO;
import net.prathap.shoppingbackend.dto.Catagory;

@Repository("catagoryDAO")
/*@EnableTransactionManagement*/
public class CatagoryDAOImpl implements CatagoryDAO {
	@Autowired
	private SessionFactory factory;
	private Session ses;
	private Transaction tx;
	public CatagoryDAOImpl() {
		System.out.println("DAOConstructor IS Executing");
	}
	
	public List<Catagory> Sendcatagaries() {	
		List<Catagory> list=null;
		Query<Catagory> query=null;
		ses=factory.openSession();
		query=ses.createQuery("from Catagory");
		list=query.getResultList();
		return list;
	}

	public Catagory SendOne(int id) {
		
		List<Catagory> list=null;
		list=Sendcatagaries();
		for (Catagory cat : list) {
			if (cat.getCatagoryid() == id) {
				System.out.println("DAO SEND ONE"+cat.getCatagoryid()+"----iD"+id+"--"+cat.isActive());
				return cat;
			}
		}
		return null;

	}
	@Transactional
	public boolean saveCatagoryToDB(Catagory cat) {
		boolean flag = false;
		boolean result = false;
		System.out.println(factory.getClass().getName()+"-------");
		ses = factory.openSession();
		if (cat != null) {
			tx = ses.beginTransaction();
			try {
				ses.persist(cat);
				flag = true;
				return flag;
			} catch (HibernateException he) {
				he.printStackTrace();
				return flag;
			} catch (Exception e) {
				e.printStackTrace();
				return flag;
			} finally {
				if (flag) {
					tx.commit();
					result = true;
				} else {
					tx.rollback();
					result = false;
				}
			}

		}
		return result;
	}
}
