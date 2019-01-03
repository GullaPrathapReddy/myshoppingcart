package net.prathap.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.prathap.shoppingbackend.dao.ProductDAO;
import net.prathap.shoppingbackend.dto.Product;

@Repository("productDAO")
/*@Transactional*/
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory factory;

	private Session ses;
	private Transaction tx;
	public ProductDAOImpl() {
		System.out.println("SESSION FACTROY PRODUCT DAOIMPL");
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Product> listProduct() {
		List<Product> list;
		Query<Product> query = null;

		ses = factory.openSession();
		query = ses.createQuery("from Product");
		list = query.getResultList();

		return list;
	}

	public Product getProduct(int productid) {
		System.out.println("GET PRODUCT METHOD IS EXECUTING");
		Product product = null;
		ses = factory.openSession();
		try {
			product = ses.get(Product.class, productid);
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	public boolean add(Product product) {
		System.out.println("ADD ETHOD IS EXECUTING");
		boolean flag= false;
		boolean result=false;
		try {
			ses=factory.openSession();
			tx=ses.beginTransaction();
			ses.persist(product);
			flag=true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally{
			if(flag) {
				tx.commit();
				result=true;
			}else {
				tx.rollback();
				result=false;
			}
		}

		return result;
	}

	public boolean update(Product product) {
		System.out.println("Update PRODUCT METHOD IS EXECUTING DAO");
		boolean flag= false;
		boolean result=false;
		try {
			ses=factory.openSession();
			tx=ses.beginTransaction();
			ses.update(product);
			flag=true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				result=true;
			}else {
				tx.rollback();
				result=false;
			}
		}
		return result;
	}

	public boolean delete(Product product) {
		product.setActive(false);
		System.out.println("DELETE PRODUCT METHOD IS EXECUTING");
		return this.update(product);
	}

	public List<Product> listActiveProducts() {
		List<Product> listpro = null;
		try {
			listpro = factory.openSession().createQuery("from Product WHERE active=:active", Product.class)
					.setParameter("active", true).getResultList();
			return listpro;
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> listActiveProductsByCategory(int categoryId) {
		final String listactiveByCatagoery = "from Product where active=:active and catagory_id=:categoryid";
		List<Product> listcat = null;
		try {
			ses=factory.openSession();
			tx=ses.beginTransaction();
			Query<Product> query=null;
				query=ses.createQuery(listactiveByCatagoery);
				query.setParameter("active", true);
				query.setParameter("categoryid", categoryId);
			try {
				listcat=query.getResultList();
				
			}catch(HibernateException he) {
				he.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listcat;
	}

	public List<Product> getLatestActiveProducts(int count) {
		try {
			return factory.openSession()
					.createQuery("FROM Product where active=:active order by id", Product.class)
					.setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
