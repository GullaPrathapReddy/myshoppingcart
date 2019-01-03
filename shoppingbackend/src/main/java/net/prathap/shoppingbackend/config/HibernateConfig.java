package net.prathap.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.prathap.shoppingbackend.dto.Catagory;
import net.prathap.shoppingbackend.dto.Product;

@Configuration
@ComponentScan(basePackages= {"net.prathap.shoppingbackend.dao","net.prathap.shoppingbackend.daoimpl"})
public class HibernateConfig {
	public HibernateConfig() {
		System.out.println("Hibernate_Config Is Executing");
	}
	
	/*private static final String Dr_className="org.h2.Driver";
	private static final String Url="jdbc:h2:tcp://localhost/~/myshopping";
	private static final String Username="root";
	private static final String password="86882";*/
	private static final String Dr_className="com.mysql.jdbc.Driver";
	private static final String Url="jdbc:mysql:///shoppingcart";
	private static final String Username="root";
	private static final String password="86882";
		/*Configuring DataSource*/
	@Bean("ds")
	public DataSource GetDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(Dr_className);
		ds.setUrl(Url);
		ds.setUsername(Username);
		ds.setPassword(password);
		return ds;
	}
	
	/*configuring SessionFactory*/
	@Bean("locsesfact")
	public LocalSessionFactoryBean CreateLocalSessionFactoryBean() {
		LocalSessionFactoryBean locfact=new LocalSessionFactoryBean();
		locfact.setDataSource(GetDataSource());
		locfact.setAnnotatedPackages("net.prathap.shoppingbackend.dto");
		locfact.setAnnotatedClasses(Catagory.class,Product.class);
		//Hibernate Properties
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.format_sql", "true");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		locfact.setHibernateProperties(prop);
		System.out.println("LocalSession---Config"+locfact);
		return locfact;
	}
	
	/*@Bean("sesfact")
	public SessionFactory GetSesFact() {
		System.out.println(CreateLocalSessionFactoryBean().getObject()+"SESSION FACTORY");
		return CreateLocalSessionFactoryBean().getObject();
	}
	*/
}
