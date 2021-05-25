package model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReceitaIngredienteService { 
    
	public List<ReceitaIngrediente> listfromreceita(long id_receita){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");        
            EntityManager em = emf.createEntityManager();
            List<ReceitaIngrediente> receitaIngrediente = null;

            Query query = em.createQuery("SELECT u FROM receita_ingrediente u where u.id_receita = :id_receita").setParameter("id_receita", id_receita);
            receitaIngrediente = query.getResultList();
         
            em.close();
            emf.close();
            return receitaIngrediente;            
	}

    public List<ReceitaIngrediente> listfromingrediente(long id_ingrediente){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");        
        EntityManager em = emf.createEntityManager();
        List<ReceitaIngrediente> receitaIngrediente = null;

        Query query = em.createQuery("SELECT u FROM receita_ingrediente u where u.id_ingrediente = :id_ingrediente").setParameter("id_ingrediente", id_ingrediente);
        receitaIngrediente = query.getResultList();
     
        em.close();
        emf.close();
        return receitaIngrediente;            
}
    
    
    public void create(String medida, long id_receita, long id_ingrediente) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        ReceitaIngrediente ri = new ReceitaIngrediente();
        ri.setMedida(medida);
        ri.setIdReceita(id_receita);
        ri.setIdIngrediente(id_ingrediente);

        em.getTransaction().begin();
        em.persist(ri);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public void delete(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        ReceitaIngrediente receitaIngrediente = em.find(ReceitaIngrediente.class, id);

        em.getTransaction().begin();
        em.remove(receitaIngrediente);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}