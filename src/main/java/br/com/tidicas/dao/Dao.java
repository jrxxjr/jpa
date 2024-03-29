package br.com.tidicas.dao;

import java.util.List;
import javax.persistence.EntityManager;
                  
/**
 * Classe genérica para manipular as funcionalidades de banco de dados 
 * 
 * @author Evaldo Junior
 */
public class Dao<T>{                                                   
   private final EntityManager em;                                     
   private final Class<T> classe;                                      
                                                                       
   public Dao(EntityManager em, Class<T> classe){                      
      this.em = em;                                                    
      this.classe = classe;                                            
   }                                                                   
                                                                       
   public T busca(Integer id){                                         
      return this.em.getReference(classe, id);                         
   }                                                                   
                                                                       
   public List<T> lista(){                                             
      return em.createQuery("from " + classe.getName()).getResultList();
   }                                                                   
                                                                       
   public void adiciona(T t){                                          
      this.em.persist(t);                                              
   }                                                                   
                                                                       
   public void remove(T t){                                            
      this.em.remove(t);                                               
   }
   public void atualiza(T t){                                          
	      this.em.merge(t);                                              
   }
   public void removeQuery(T t,Integer chave){                                            
	      this.em.createQuery("delete from " + classe.getName() + " where codigo = " + chave).executeUpdate();    
	      
   }
}