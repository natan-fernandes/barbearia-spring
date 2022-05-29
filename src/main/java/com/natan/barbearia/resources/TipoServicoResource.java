package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.TipoServicoDto;
import com.natan.barbearia.models.TipoServico;
import com.natan.barbearia.services.TipoServicoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class TipoServicoResource {
    private final TipoServicoService tipoServicoService;

    public TipoServicoResource(TipoServicoService tipoServicoService) {
        this.tipoServicoService = tipoServicoService;
    }

    @GetMapping("/obterTodos")
    public List<TipoServicoDto> obterTodos() {
        return tipoServicoService.obterTodos();
    }
}
