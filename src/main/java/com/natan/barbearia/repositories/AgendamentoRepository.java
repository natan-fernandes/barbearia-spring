package com.natan.barbearia.repositories;

import com.natan.barbearia.models.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    @Query(value = "select a from Agendamento  a where a.dataCadastro >= :dataInicial and a.dataCadastro <= :dataFinal")
    List<Agendamento> obterPorDataCadastro(@Param("dataInicial") Instant dataInicial,
                                           @Param("dataFinal") Instant dataFinal);
}
