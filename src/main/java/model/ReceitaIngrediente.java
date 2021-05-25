package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="receita_ingrediente")
public class ReceitaIngrediente { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  long id;           
    @Column(name="medida")
    private String medida;
    @Column(name="id_receita")
    private  long id_receita;  
    @Column(name="id_ingrediente")
    private  long id_ingrediente;  

    public ReceitaIngrediente(){}          
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }  
    public String getMedida() {   
        return medida;
    }
    public void setMedida(String nome) {
        this.medida = nome;
    }
    
    public long getIdReceita() {
        return id_receita;
    }
    public void setIdReceita(long id_receita) {
        this.id_receita = id_receita;
    }
    
    public long getIdIngrediente() {
        return id_ingrediente;
    }
    public void setIdIngrediente(long id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }
}