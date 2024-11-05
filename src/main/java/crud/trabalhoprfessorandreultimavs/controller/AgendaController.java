package crud.trabalhoprfessorandreultimavs.controller;

import crud.trabalhoprfessorandreultimavs.entity.Agenda;
import crud.trabalhoprfessorandreultimavs.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    @GetMapping("/{id}")
    public Optional<Agenda> getAgendaById(@PathVariable Integer id) {
        return agendaService.getAgendaById(id);
    }

    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        return agendaService.createAgenda(agenda);
    }

    @PutMapping("/{id}")
    public Agenda updateAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
        return agendaService.updateAgenda(id, agenda);
    }

    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable Integer id) {
        agendaService.deleteAgenda(id);
    }

    @PutMapping("/{id}/realizar")
    public Agenda realizarServico(@PathVariable Integer id) {
        return agendaService.realizarServico(id);
    }
}
