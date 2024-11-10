package crud.trabalhoprfessorandreultimavs.controller;

import crud.trabalhoprfessorandreultimavs.entity.Agenda;
import crud.trabalhoprfessorandreultimavs.entity.TipoAcesso;
import crud.trabalhoprfessorandreultimavs.entity.Usuario;
import crud.trabalhoprfessorandreultimavs.service.TipoAcessoService;
import crud.trabalhoprfessorandreultimavs.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import crud.trabalhoprfessorandreultimavs.entity.TipoAcesso.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    TipoAcessoService tipoAcessoService = new TipoAcessoService();
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = usuarioService.createUsuario(usuario);
            //novoUsuario.setTipoAcesso(true);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioService.updateUsuario(id, usuario);
        if (usuarioAtualizado != null) {
            return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarUsuario(@PathVariable Integer id) {
        try {
            usuarioService.deleteUsuario(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }


  /* *//* public Usuario atualizarTipoAcesso(String tipoAcesso) {
        // Exemplo de busca do usuário (ajuste conforme necessário)
        Usuario usuario = getUsuarioById(); // Suponha que este método retorne o usuário atual ou um específico
        if (usuario != null) {
            usuario.setTipoAcesso(tipoAcesso); // Atualiza a string com o tipo de acesso
            salvarUsuario(usuario); // método que salva o usuário atualizado
            return usuario;
        }*//*
        return null;
    }*/


}

