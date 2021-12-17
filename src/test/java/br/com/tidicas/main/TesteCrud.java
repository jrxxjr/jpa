package br.com.tidicas.main;

import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import br.com.tidicas.dao.BlogDao;
import br.com.tidicas.dao.CategoriaDao;
import br.com.tidicas.dao.JpaUtil;
import br.com.tidicas.model.Blog;
import br.com.tidicas.model.Categoria;
import junit.framework.TestCase;

/**
 * Classe para geração das tabelas e teste com operacoes crud
 *  
 * @author Evaldo Junior
 *
 */
public class TesteCrud extends TestCase {
	
	private static final Logger LOGGER = Logger.getLogger(TesteCrud.class.getName());
	
	public static void testCrud(){		
				
		EntityManager em = new JpaUtil().getEntityManager();

		CategoriaDao daoCategoria = new CategoriaDao(em);                 
		BlogDao daoBlog = new BlogDao(em);
		
		// 1 Entidade Categoria
		Categoria categoria1 = new Categoria();				                               
		categoria1.setDescricao("categoria 1");                              
		
		Categoria categoria2 = new Categoria();				                               
		categoria2.setDescricao("categoria 2");                              
		
		em.getTransaction().begin();                     
		daoCategoria.adiciona(categoria1);                                 
		em.getTransaction().commit(); 
		
		em.getTransaction().begin();                     
		daoCategoria.adiciona(categoria2);                                 
		em.getTransaction().commit();
		   
		categoria1 = daoCategoria.busca(categoria1.getCodigo());
		LOGGER.info("retorno :" + categoria1.getCodigo());
		   
		categoria2 = daoCategoria.busca(categoria2.getCodigo());
		LOGGER.info("retorno :" + categoria2.getCodigo());
				
		em.getTransaction().begin();
		categoria1.setDescricao("categoria1 update"); 
		daoCategoria.atualiza(categoria1);		   
		em.getTransaction().commit();
		   
		em.getTransaction().begin();
		categoria2.setDescricao("categoria2 update"); 
		daoCategoria.atualiza(categoria2);		   
		em.getTransaction().commit();
		
		// 2 Entidade Blog
		Blog blog1 = new Blog();
		blog1.setCategoria(categoria1);
		blog1.setConteudo("conteúdo teste");
		blog1.setDtevento(new Date());
		blog1.setPublicar(1);
		blog1.setTitulo("titulo");
		
		em.getTransaction().begin();                     
		daoBlog.adiciona(blog1);                                 
		em.getTransaction().commit(); 
		
		blog1 = daoBlog.busca(blog1.getCodigo());
		LOGGER.info("retorno:" + blog1.getTitulo());
				
		blog1.setConteudo("conteúdo teste update");
		blog1.setDtevento(new Date());
		blog1.setPublicar(0);
		blog1.setTitulo("título update");
		
		em.getTransaction().begin();		 
		daoBlog.atualiza(blog1);		   
		em.getTransaction().commit();
		
		blog1 = daoBlog.busca(blog1.getCodigo());	
		LOGGER.info("retorno:" + blog1.getTitulo());
				
		/*
		 * em.getTransaction().begin(); daoCategoria.remove(categoria1);
		 * daoCategoria.remove(categoria2); daoBlog.remove(blog1);
		 * em.getTransaction().commit();
		 */ 
		LOGGER.info("delete:" + blog1.getTitulo());
				
	}
}