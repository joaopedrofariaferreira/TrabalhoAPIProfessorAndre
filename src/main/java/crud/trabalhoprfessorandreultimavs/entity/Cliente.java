package crud.trabalhoprfessorandreultimavs.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
