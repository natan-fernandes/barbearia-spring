package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.CadastroAgendamentoDto;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.services.AgendamentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/agendamentos")
public class AgendamentoResource {
    private final AgendamentoService agendamentoService;

    public AgendamentoResource(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/agendar")
    public Agendamento agendar(CadastroAgendamentoDto cadastroAgendamentoDto) {
        return agendamentoService.cadastrar(cadastroAgendamentoDto);
    }
}
