package com.natan.barbearia.services;

import com.natan.barbearia.dtos.RelacaoServicoDto;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.models.TipoServico;
import com.natan.barbearia.repositories.AgendamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record RelatorioService(AgendamentoRepository agendamentoRepository,
                               ModelMapper mapper) {
    public List<RelacaoServicoDto> obterRelacao() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        List<TipoServico> tiposServico = agendamentos.stream().flatMap(x -> x.getTiposServico().stream()).toList();
        List<String> descricoes = tiposServico.stream().map(TipoServico::getDescricao).distinct().toList();

        List<RelacaoServicoDto> relacoes = new ArrayList<>();
        for (String descricao : descricoes) {
            RelacaoServicoDto relacao = new RelacaoServicoDto();
            relacao.setTipoServico(descricao);
            double porcentagem = tiposServico.stream().filter(x -> x.getDescricao().equals(descricao)).count() / (double)tiposServico.size();
            relacao.setPorcentagem(porcentagem);
            relacoes.add(relacao);
        }
        return relacoes;
    }
}
