package br.uel.Cadastro_Produtos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;
    
    @Column(name = "preco", nullable = false)
    private Double preco; 

    @Column(name = "quantidade")
    private Integer quantidade;

    public Produto() {}
    public Produto(String nome, Double preco, Integer quantidade){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Long getId() { return id; }
    public void setId(Long id){this.id = id;}

    public String getNome(){ return nome;}
    public void setNome(){this.nome = nome;}

    public Double getPreco(){ return preco;}
    public void setPreci(){this.preco = preco;}

    public Integer getQuantidade(){ return quantidade;}
    public void setQuantidade(Integer quantidade){this.quantidade = quantidade;}

}
