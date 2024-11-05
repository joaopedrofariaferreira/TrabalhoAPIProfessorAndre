package crud.trabalhoprfessorandreultimavs.repository;

import crud.trabalhoprfessorandreultimavs.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
