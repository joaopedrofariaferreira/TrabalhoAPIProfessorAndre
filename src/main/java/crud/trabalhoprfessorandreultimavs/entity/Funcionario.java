package crud.trabalhoprfessorandreultimavs.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private Double salario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;




}