package com.natan.barbearia.services;

import com.natan.barbearia.dtos.CadastroUserDto;
import com.natan.barbearia.dtos.RelacaoServicoDto;
import com.natan.barbearia.exceptions.UserAlreadyExistsException;
import com.natan.barbearia.exceptions.WeakPasswordException;
import com.natan.barbearia.models.Agendamento;
import com.natan.barbearia.models.TipoServico;
import com.natan.barbearia.models.User;
import com.natan.barbearia.repositories.AgendamentoRepository;
import com.natan.barbearia.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public record AuthService(UserRepository userRepository,
                          ModelMapper mapper) {
    public User registrar(CadastroUserDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent())
            throw new UserAlreadyExistsException("Já existe um usuário cadastrado com este email");

        if (dto.getSenha().length() == 0)
            throw new WeakPasswordException("A senha não pode ser vazia");

        dto.setSenha(new BCryptPasswordEncoder().encode(dto.getSenha()));
        User user = mapper.map(dto, User.class);
        return userRepository.save(user);
    }
}
