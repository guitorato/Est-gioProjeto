package com.qintess.estudo.hibernate.config;


import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.qintess.estudo.hibernate.modelo.Cliente;
import com.qintess.estudo.hibernate.modelo.Fornecedor;
import com.qintess.estudo.hibernate.modelo.FornecedorProduto;
import com.qintess.estudo.hibernate.modelo.ItemVenda;
import com.qintess.estudo.hibernate.modelo.Produto;
import com.qintess.estudo.hibernate.modelo.Venda;

public class HibernateConfig {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory () {
		
		if(sessionFactory==null) {
			try {
				
				Configuration configuration = new Configuration();
				
				Properties prop = new Properties();
				
				prop.put(Environment.DRIVER,"org.h2.Driver");
				prop.put(Environment.URL,"jdbc:h2:tcp://localhost/~/livraria");
				prop.put(Environment.USER,"root");
				prop.put(Environment.PASS,"");
				prop.put(Environment.DIALECT,"org.hibernate.dialect.H2Dialect");
				
				prop.put(Environment.SHOW_SQL,"TRUE");
				prop.put(Environment.HBM2DDL_AUTO,"create-drop");
				
				configuration.setProperties(prop);
				
				configuration.addAnnotatedClass(Produto.class);
				configuration.addAnnotatedClass(ItemVenda.class);
				configuration.addAnnotatedClass(Venda.class);
				configuration.addAnnotatedClass(FornecedorProduto.class);
				configuration.addAnnotatedClass(Cliente.class);
				configuration.addAnnotatedClass(Fornecedor.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
}
