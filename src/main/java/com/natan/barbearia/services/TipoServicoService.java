package com.natan.barbearia.services;

import com.natan.barbearia.dtos.TipoServicoDto;
import com.natan.barbearia.repositories.TipoServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public record TipoServicoService(TipoServicoRepository tipoServicoRepository,
                                 ModelMapper mapper) {
    public List<TipoServicoDto> obterTodos() {
        return Arrays.asList(mapper.map(tipoServicoRepository.findAll(), TipoServicoDto[].class));
    }
}
