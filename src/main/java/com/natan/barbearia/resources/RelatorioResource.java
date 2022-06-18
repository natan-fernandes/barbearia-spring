package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.RelacaoServicoDto;
import com.natan.barbearia.services.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/relatorio")
public class RelatorioResource {
    private final RelatorioService relatorioService;

    public RelatorioResource(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/relacaoServicos")
    public List<RelacaoServicoDto> obterRelacao() {
        return relatorioService.obterRelacao();
    }
}
