package com.natan.barbearia.repositories;

import com.natan.barbearia.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
