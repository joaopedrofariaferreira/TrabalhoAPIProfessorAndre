package crud.trabalhoprfessorandreultimavs.controller;


import crud.trabalhoprfessorandreultimavs.entity.Funcionario;
import crud.trabalhoprfessorandreultimavs.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {



    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public List<Funcionario> getAllFuncionarios() {
        return funcionarioService.getAllFuncionarios();
    }


    @GetMapping("/{id}")
    public Optional<Funcionario> getFuncionarioById(@PathVariable Integer id) {
        return funcionarioService.getFuncionarioById(id);
    }


    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioService.createFuncionario(funcionario);
    }


    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
        return funcionarioService.updateFuncionario(id, funcionario);
    }


    @DeleteMapping("/{id}")
    public void deleteFuncionario(@PathVariable Integer id) {
        funcionarioService.deleteFuncionario(id);
    }
}
