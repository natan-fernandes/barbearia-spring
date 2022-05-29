package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.CadastroAgendamentoDto;
import com.natan.barbearia.exceptions.EquipeNotFoundException;
import com.natan.barbearia.exceptions.TipoServicoNotFound;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/agendamentos")
public class AgendamentoResource {
    private final AgendamentoService agendamentoService;

    public AgendamentoResource(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/agendar")
    public ResponseEntity<Agendamento> agendar(@RequestBody CadastroAgendamentoDto cadastroAgendamentoDto)
            throws TipoServicoNotFound, EquipeNotFoundException {
        return ResponseEntity.ok(agendamentoService.cadastrar(cadastroAgendamentoDto));
    }
}
