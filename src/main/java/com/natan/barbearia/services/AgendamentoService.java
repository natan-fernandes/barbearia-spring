package com.natan.barbearia.services;

import com.natan.barbearia.dtos.CadastroAgendamentoDto;
import com.natan.barbearia.enums.TiposServico;
import com.natan.barbearia.exceptions.EquipeNotFoundException;
import com.natan.barbearia.exceptions.TipoServicoNotFound;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.models.Equipe;
import com.natan.barbearia.models.TipoServico;
import com.natan.barbearia.repositories.AgendamentoRepository;
import com.natan.barbearia.repositories.EquipeRepository;
import com.natan.barbearia.repositories.TipoServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public record AgendamentoService(AgendamentoRepository agendamentoRepository,
                                 EquipeRepository equipeRepository,
                                 TipoServicoRepository tipoServicoRepository,
                                 ModelMapper mapper) {

    public Agendamento cadastrar(CadastroAgendamentoDto dto)
            throws EquipeNotFoundException, TipoServicoNotFound {
        Agendamento agendamento = mapper.map(dto, Agendamento.class);

        Optional<Equipe> equipe = equipeRepository.findById(dto.getEquipeId());
        if (equipe.isEmpty())
            throw new EquipeNotFoundException(String.format("Nenhuma equipe com id '%s' foi encontrada.", dto.getEquipeId()));
        agendamento.setEquipe(equipe.get());

        List<TipoServico> tiposServico = tipoServicoRepository.findAllById(dto.getServicosIds());
        if (tiposServico.isEmpty()) {
            String idsServico = dto.getServicosIds().stream().map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            throw new TipoServicoNotFound(String.format("Nenhum tipo de serviço com ids %s foram encontrados", idsServico));
        }

        tiposServico = getTiposServicoFiltrados(tiposServico);
        agendamento.setTiposServico(tiposServico);

        return agendamentoRepository.save(agendamento);
    }

    /**
     * Se selecionado "Corte e Barba", remove "Corte" e "Barba" da lista.
     */
    private List<TipoServico> getTiposServicoFiltrados(List<TipoServico> tiposServico) {
        Stream<TipoServico> tiposServicoStream = tiposServico.stream();
        if (tiposServicoStream.anyMatch(x -> x.getId() == TiposServico.CorteBarba.getValue())) {
            tiposServico = tiposServico.stream().filter(x -> x.getId() != TiposServico.Barba.getValue()
                                                            && x.getId() != TiposServico.Corte.getValue()).toList();
        }

        return tiposServico;
    }
}
