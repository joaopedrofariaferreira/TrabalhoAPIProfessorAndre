package crud.trabalhoprfessorandreultimavs.repository;


import crud.trabalhoprfessorandreultimavs.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {



}
