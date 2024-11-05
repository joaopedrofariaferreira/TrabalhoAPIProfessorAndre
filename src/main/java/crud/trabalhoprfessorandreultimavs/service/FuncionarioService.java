package crud.trabalhoprfessorandreultimavs.service;


import crud.trabalhoprfessorandreultimavs.entity.Funcionario;
import crud.trabalhoprfessorandreultimavs.repository.FuncionarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FuncionarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private FuncionarioRepository funcionarioRepository;




    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Integer id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario createFuncionario(Funcionario funcionario) {
        //return funcionarioRepository.save(funcionario);
        return entityManager.merge(funcionario);
    }

    public Funcionario updateFuncionario(Integer id, Funcionario funcionario) {
        if (funcionarioRepository.existsById(id)) {
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        }
        return null;
    }

    public void deleteFuncionario(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}

