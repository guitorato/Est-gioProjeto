package com.qintess.evento.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


@Repository
@EnableTransactionManagement
public class Dao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public <T> void salva(T entidade) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		session.save(entidade);
		
	}
	
	@Transactional
	public <T> void altera(T entidade) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		session.merge(entidade);
	}
	
	@Transactional
	public <T> void deleta(T entidade) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		session.remove(entidade);
	}
	
	@Transactional
	public <T> List<T> buscaTodos(Class<T> nomeClasse) {
		
		Session session = this.sessionFactory.getCurrentSession();
	
		String jpql ="from "+ nomeClasse.getName();
		TypedQuery<T> query = session.createQuery(jpql,nomeClasse);
		
		return query.getResultList();
	
	}
	
	@Transactional
	public <T> T buscaPorId(Class<T> nomeClasse, int id) {
		
		Session session = this.sessionFactory.getCurrentSession();
			
		// o .get realiza um select com where no id da entidade
		return session.get(nomeClasse, id);
	}

}
