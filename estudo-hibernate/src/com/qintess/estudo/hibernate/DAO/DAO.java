package com.qintess.estudo.hibernate.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qintess.estudo.hibernate.config.HibernateConfig;

public class DAO<E> {
	
	;

	public DAO<E> salvar(E entidade) {
		Transaction transacao = null;
		
		try(Session session = HibernateConfig.getSessionFactory().openSession()) {
			
			transacao = session.beginTransaction();
					
			session.save(entidade);
			
			transacao.commit();
			
		} catch (Exception e) {
			if(transacao != null) {
				transacao.rollback();
			}
			
			e.printStackTrace();
		}
		
		return this;
	}
		
	public List<E> obterTodos(Class<E> classe){
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		String jpql ="select e from "+ classe.getName() +" e";
		TypedQuery<E> query = session.createQuery(jpql,classe);
		
		return query.getResultList();
	}
		
	
	
}
