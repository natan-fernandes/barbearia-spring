package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.CadastroAgendamentoDto;
import com.natan.barbearia.enums.FiltrosAgenda;
import com.natan.barbearia.exceptions.EquipeNotFoundException;
import com.natan.barbearia.exceptions.TipoServicoNotFoundException;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.services.AgendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/agenda")
public class AgendaResource {
    private final AgendaService agendaService;

    public AgendaResource(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping("/agendar")
    public ResponseEntity<Agendamento> agendar(@RequestBody CadastroAgendamentoDto cadastroAgendamentoDto)
            throws TipoServicoNotFoundException, EquipeNotFoundException {
        return ResponseEntity.ok(agendaService.cadastrar(cadastroAgendamentoDto));
    }

    @GetMapping("/obterAgendamentos/{filtro}")
    public List<Agendamento> obterAgendamentos(@PathVariable FiltrosAgenda filtro) {
        return agendaService.getAgendamentos(filtro);
    }

    @GetMapping("/cliente/{id}")
    public List<Agendamento> obterAgendamentosCliente(@PathVariable long id) {
        return agendaService.obterPorClienteId(id);
    }
}
