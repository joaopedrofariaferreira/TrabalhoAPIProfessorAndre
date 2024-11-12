package crud.trabalhoprfessorandreultimavs.controller;

import crud.trabalhoprfessorandreultimavs.entity.Agenda;
import crud.trabalhoprfessorandreultimavs.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        boolean clienteExists = agendaService.isClienteExists(agenda.getCliente());
        if (clienteExists == true) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cliente com este nome na agenda");
        }
        return agendaService.createAgenda(agenda);
    }

   /* @PutMapping("/{id}")
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
    }*/

    // Método para atualizar um registro de agenda
    @PutMapping("/{id}")
    public Agenda updateAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
        Optional<Agenda> existingAgenda = agendaService.getAgendaById(id);
        if (existingAgenda.get().getStatus()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Edição não permitida para registros com status true");
        }
        return agendaService.updateAgenda(id, agenda);
    }

    // Método para excluir um registro de agenda
    @DeleteMapping("/{id}")
    public void deleteAgenda(@PathVariable Integer id) {
        Optional<Agenda> existingAgenda = agendaService.getAgendaById(id);
        if (existingAgenda.get().getStatus()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Exclusão não permitida para registros com status true");
        }
        agendaService.deleteAgenda(id);
    }

    // Método para marcar um serviço como realizado
    @PutMapping("/{id}/realizar")
    public Agenda realizarServico(@PathVariable Integer id) {
        Optional <Agenda> existingAgenda = agendaService.getAgendaById(id);
        if (existingAgenda.get().getStatus()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Registro já realizado e não pode ser alterado");
        }
        return agendaService.realizarServico(id);
    }

   /* // Método para criar um novo registro na agenda
    @PostMapping
    public Agenda createAgenda(@RequestBody Agenda agenda) {
        boolean clienteExists = agendaService.isClienteExists(agenda.getCliente());
        if (clienteExists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um cliente com este nome na agenda");
        }
        return agendaService.createAgenda(agenda);
    }*/
}
