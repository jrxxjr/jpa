package br.com.tidicas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que controla as instancias da conexao com o banco de dados 
 * 
 * @author Evaldo Junior
 */
public class JpaUtil {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpateste");
	   public EntityManager getEntityManager(){
	      return entityManagerFactory.createEntityManager();
	   }                                                                      
}
