package crud.trabalhoprfessorandreultimavs.repository;


import crud.trabalhoprfessorandreultimavs.entity.TipoAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipoAcessoRepository extends JpaRepository<TipoAcesso, Integer> {

    // Consulta para buscar tipos de acesso pela descrição
    List<TipoAcesso> findByDescricao(String descricao);
}
