package br.com.tidicas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.tidicas.model.Blog;
                                                 
/**
 * Classe para manipular as operacoes de banco de dados 
 * da tabela blog
 * 
 * @author Evaldo Junior
 */
public class BlogDao{
   private final Dao<Blog> dao;                 
   private final EntityManager em;               
                                                 
   public BlogDao(EntityManager em){
     this.dao = new Dao<Blog>(em, Blog.class); 
     this.em = em;
   }
                                                 
   public void adiciona(Blog blog){            
      this.dao.adiciona(blog);
   }
                                                 
   public void remove(Blog blog){
      this.dao.remove(blog);
   }
      
   public void atualiza(Blog blog){
	   this.dao.atualiza(blog);
   }
   
   public List<Blog> lista(){
	   return this.dao.lista();
   }
                                                 
   public Blog busca(Integer id){
	   return dao.busca(id);
   }
	
   public void removeQuery(Blog blog,Integer chave){
	   this.dao.removeQuery(blog,chave);
   }
	
}