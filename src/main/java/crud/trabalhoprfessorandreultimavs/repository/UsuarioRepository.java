package crud.trabalhoprfessorandreultimavs.repository;


import crud.trabalhoprfessorandreultimavs.entity.TipoAcesso;
import crud.trabalhoprfessorandreultimavs.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Consulta para buscar usuários por nome de usuário
    List<Usuario> findByUsuario(String usuario);

    // Consulta para buscar usuários por tipo de acesso
    List<Usuario> findByTipoAcesso(TipoAcesso tipoAcesso);
}
