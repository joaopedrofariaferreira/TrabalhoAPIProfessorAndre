package crud.trabalhoprfessorandreultimavs.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String usuario;
    private String email;
    private String senha;
    private Date dtCadastro;

    @ManyToOne
    private TipoAcesso tipoAcesso;
}
