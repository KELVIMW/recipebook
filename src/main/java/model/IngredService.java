package model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class IngredService { 
    
	public List<Ingrediente> list(){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");        
            EntityManager em = emf.createEntityManager();
            List<Ingrediente> ingrediente = null;

            Query query = em.createQuery("SELECT u FROM ingrediente u");
            ingrediente = query.getResultList();
            
            em.close();
            emf.close();
            return ingrediente;            
	}
        
        public Ingrediente getbyid(long id_ingrediente){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");        
            EntityManager em = emf.createEntityManager();
            Ingrediente ingrediente = null;

            Query query = em.createQuery("SELECT u FROM ingrediente u where u.id = :id_ingrediente").setParameter("id_ingrediente", id_ingrediente);
            ingrediente = (Ingrediente) query.getSingleResult();
            
            em.close();
            emf.close();
            return ingrediente;            
	}
    public void create(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        Ingrediente i = new Ingrediente();
        i.setNome(nome);

        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

   /* public void update(String nome) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        Ingrediente i = new Ingrediente();
        i.setNome(nome);

        em.getTransaction().begin();
        em.persist(i);
        em.merge();
        em.getTransaction().commit();
        em.close();
        emf.close();
    }*/

    public void delete(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        Ingrediente ingrediente = em.find(Ingrediente.class, id);

        em.getTransaction().begin();
        em.remove(ingrediente);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}