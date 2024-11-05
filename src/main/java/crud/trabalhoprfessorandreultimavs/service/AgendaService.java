
package crud.trabalhoprfessorandreultimavs.service;

import crud.trabalhoprfessorandreultimavs.entity.Agenda;
import crud.trabalhoprfessorandreultimavs.repository.AgendaRepository;
import crud.trabalhoprfessorandreultimavs.repository.FuncionarioRepository;
import crud.trabalhoprfessorandreultimavs.repository.ServicoRepository;
import crud.trabalhoprfessorandreultimavs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Agenda> getAllAgendas() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> getAgendaById(Integer id) {
        return agendaRepository.findById(id);
    }

    public Agenda createAgenda(Agenda agenda) {
        if (agenda.getFuncionario() != null && agenda.getFuncionario().getId() != null) {
            agenda.setFuncionario(funcionarioRepository.findById(agenda.getFuncionario().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado")));
        }
        if (agenda.getServico() != null && agenda.getServico().getId() != null) {
            agenda.setServico(servicoRepository.findById(agenda.getServico().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Servico não encontrado")));
        }
        if (agenda.getUsuario() != null && agenda.getUsuario().getId() != null) {
            agenda.setUsuario(usuarioRepository.findById(agenda.getUsuario().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado")));
        }
        agenda.setStatus(false);
        return agendaRepository.save(agenda);
    }

    public Agenda updateAgenda(Integer id, Agenda agenda) {
        Optional<Agenda> existingAgenda = agendaRepository.findById(id);
        if (existingAgenda.isPresent() && !existingAgenda.get().getStatus()) {
            agenda.setId(id);
            return agendaRepository.save(agenda);
        }
        return null;
    }

    public void deleteAgenda(Integer id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        if (agenda.isPresent() && !agenda.get().getStatus()) {
            agendaRepository.deleteById(id);
        }
    }

    public Agenda realizarServico(Integer id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        if (agenda.isPresent()) {
            Agenda updatedAgenda = agenda.get();
            updatedAgenda.setStatus(true);
            return agendaRepository.save(updatedAgenda);
        }
        return null;
    }
}
