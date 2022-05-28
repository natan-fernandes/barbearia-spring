package com.natan.barbearia;

import com.natan.barbearia.enums.TiposServico;
import com.natan.barbearia.models.Equipe;
import com.natan.barbearia.models.TipoServico;
import com.natan.barbearia.repositories.EquipeRepository;
import com.natan.barbearia.repositories.TipoServicoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BarbeariaApplication implements CommandLineRunner {
	private final TipoServicoRepository tipoServicoRepository;
	private final EquipeRepository equipeRepository;

	public BarbeariaApplication(TipoServicoRepository tipoServicoRepository,
								EquipeRepository equipeRepository) {
		this.tipoServicoRepository = tipoServicoRepository;
		this.equipeRepository = equipeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BarbeariaApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) {
		if (tipoServicoRepository.count() == 0) {
			List<TipoServico> tiposServico = new ArrayList<>();
			Arrays.stream(TiposServico.values()).forEach(x ->
					tiposServico.add(new TipoServico(x.getNome(), x.getPreco())));
			tipoServicoRepository.saveAll(tiposServico);
		}
		if (equipeRepository.count() == 0)
			equipeRepository.save(new Equipe("Zezin da Silva"));
	}
}
