package crud.trabalhoprfessorandreultimavs.repository;


import crud.trabalhoprfessorandreultimavs.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {


    List<Endereco> findByCidade(String cidade);


    List<Endereco> findByUf(String uf);

    List<Endereco> findByCep(String cep);
}
