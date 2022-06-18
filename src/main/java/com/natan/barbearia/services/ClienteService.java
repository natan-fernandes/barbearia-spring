package com.natan.barbearia.services;

import com.natan.barbearia.dtos.CadastroClienteDto;
import com.natan.barbearia.exceptions.ClienteNotFoundException;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.models.Cliente;
import com.natan.barbearia.repositories.AgendamentoRepository;
import com.natan.barbearia.repositories.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public record ClienteService(ClienteRepository clienteRepository,
                             AgendamentoRepository agendamentoRepository,
                             ModelMapper mapper) {

   public Cliente cadastrar(CadastroClienteDto dto) {
       Cliente cliente = mapper.map(dto, Cliente.class);
       return clienteRepository.save(cliente);
   }

   public Cliente obterPorId(long id) {
       Optional<Cliente> cliente = clienteRepository.findById(id);

       if (cliente.isEmpty())
           throw new ClienteNotFoundException("Cliente não encontrado");

       return cliente.get();
   }
}
