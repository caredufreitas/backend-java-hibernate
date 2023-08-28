package br.com.qintess.livraria.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.qintess.hibernate.config.HibernateConfig;

public class Dao {
//	inserir
	public <T> void inserir(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
			session.close();
		} 
	}
//	atualizar
	public <T> void atualizar(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.merge(entidade);
			session.getTransaction().commit();
			session.close();
		}
	} 
//	deletar
	public <T> void deletar(T entidade) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(entidade);
			session.getTransaction().commit();
			session.close();
		}
	}
//	listar
	public <T> List<T> listar(Class<T> nomeClasse){
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.createQuery("FROM " + nomeClasse.getName()).getResultList();
		}
	}
//	listar por id
	public <T> T listarPorId(Class<T> nomeClasse, int id) {
		try (Session session = HibernateConfig.getSessionFactory().openSession()) {
			return session.get(nomeClasse, id);
		}
	}
	
}
