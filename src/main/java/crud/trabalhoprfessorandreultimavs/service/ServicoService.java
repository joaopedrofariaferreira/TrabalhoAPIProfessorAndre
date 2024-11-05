package crud.trabalhoprfessorandreultimavs.service;



import crud.trabalhoprfessorandreultimavs.entity.Servico;
import crud.trabalhoprfessorandreultimavs.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> getAllServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> getServicoById(Integer id) {
        return servicoRepository.findById(id);
    }

    public Servico createServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico updateServico(Integer id, Servico servico) {
        if (servicoRepository.existsById(id)) {
            servico.setId(id);
            return servicoRepository.save(servico);
        }
        return null;
    }

    public void deleteServico(Integer id) {
        servicoRepository.deleteById(id);
    }
}
