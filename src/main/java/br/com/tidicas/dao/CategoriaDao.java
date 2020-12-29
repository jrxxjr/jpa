package br.com.tidicas.dao;

import javax.persistence.EntityManager;
import br.com.tidicas.model.Categoria;
import java.util.List;    

/**
 * Classe para manipular as operacoes de banco de dados 
 * da tabela categoria
 * 
 * @author Evaldo Junior
 */
public class CategoriaDao{
   private final Dao<Categoria> dao;                 
   private final EntityManager em;
                                                 
  public CategoriaDao(EntityManager em){             
     this.dao = new Dao<Categoria>(em, Categoria.class); 
     this.em = em;
   }
                                                 
   public void adiciona(Categoria categoria){            
      this.dao.adiciona(categoria);
   }
                                                 
   public void remove(Categoria categoria){              
      this.dao.remove(categoria);
   }
      
   public void atualiza(Categoria categoria){              
	      this.dao.atualiza(categoria);
   }
   
   public List<Categoria> lista(){                   
      return this.dao.lista();
   }
                                                 
   public Categoria busca(Integer id){                 
	  return dao.busca(id);
   }
	
}