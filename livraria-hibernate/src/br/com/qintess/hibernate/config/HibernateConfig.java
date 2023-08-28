package br.com.qintess.hibernate.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import br.com.qintess.livraria.model.Autor;
import br.com.qintess.livraria.model.Cliente;
import br.com.qintess.livraria.model.Genero;
import br.com.qintess.livraria.model.Livro;
import br.com.qintess.livraria.model.LivroVenda;
import br.com.qintess.livraria.model.LivroVendaId;
import br.com.qintess.livraria.model.Venda;

public class HibernateConfig {
		
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				Properties prop = new Properties();
				prop.put(Environment.DRIVER, "org.postgresql.Driver");
				prop.put(Environment.URL, "jdbc:postgresql://localhost:5432/db_livraria_hibernate");
				prop.put(Environment.USER, "postgres");
				prop.put(Environment.PASS, "admin");
				prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				prop.put(Environment.SHOW_SQL, true);
//				prop.put(Environment.FORMAT_SQL, true);
				prop.put(Environment.HBM2DDL_AUTO, "create-drop");
				
				config.setProperties(prop);
				config.addAnnotatedClass(Autor.class);
				config.addAnnotatedClass(Cliente.class);
				config.addAnnotatedClass(Genero.class);
				config.addAnnotatedClass(Livro.class);
				config.addAnnotatedClass(Venda.class);
				config.addAnnotatedClass(LivroVenda.class);
				config.addAnnotatedClass(LivroVendaId.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties()).build();
				
				sessionFactory = config.buildSessionFactory(serviceRegistry);
			
			} catch (Exception e) {
				System.err.println("Ocorreu um erro " + e.getMessage());
			}
		}
		return sessionFactory;
	}
}
