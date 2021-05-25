package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="receita")
public class Receita { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  long id;           
    @Column(name="nome")
    private String nome;
    @Column(name="passo")
    private String passo;

    public Receita(){}          
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }  
    public String getNome() {   
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPasso() {
        return  passo;
    }
    public void setPasso(String passo){
        this.passo = passo;
    }
}