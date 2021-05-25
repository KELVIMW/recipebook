package model;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ReceitaService { 
    
	public List<Receita> list(){
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");        
            EntityManager em = emf.createEntityManager();
            List<Receita> receita = null;

            Query query = em.createQuery("SELECT u FROM receita u");
            receita = query.getResultList();
         
            em.close();
            emf.close();
            return receita;            
	}
    
    
    public Receita create(String nome, String passo) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        Receita r = new Receita();
        r.setNome(nome);
        r.setPasso(passo);

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
        emf.close();
        return r;
    }

    public void delete(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();

        Receita receita = em.find(Receita.class, id);

        em.getTransaction().begin();
        em.remove(receita);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}