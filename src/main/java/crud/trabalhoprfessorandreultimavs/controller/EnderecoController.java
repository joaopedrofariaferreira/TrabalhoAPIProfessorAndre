package crud.trabalhoprfessorandreultimavs.controller;

import crud.trabalhoprfessorandreultimavs.entity.Endereco;
import crud.trabalhoprfessorandreultimavs.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public Endereco createEndereco(@RequestBody Endereco endereco) {
        return enderecoService.createEndereco(endereco);
    }

    @GetMapping("/{cep}")
    public Endereco getEnderecoByCep(@PathVariable String cep) {
        return enderecoService.getEnderecoByCep(cep);
    }

}
