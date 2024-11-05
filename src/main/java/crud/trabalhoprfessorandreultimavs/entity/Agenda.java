package crud.trabalhoprfessorandreultimavs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Date data;
    private Boolean status = false;

    @ManyToOne(cascade = CascadeType.ALL)
    private Servico servico;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
}
