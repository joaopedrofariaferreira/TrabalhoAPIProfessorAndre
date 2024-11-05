package crud.trabalhoprfessorandreultimavs.repository;

import crud.trabalhoprfessorandreultimavs.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByNomeContaining(String nome);

    List<Servico> findByValorGreaterThan(Double valor);
}
