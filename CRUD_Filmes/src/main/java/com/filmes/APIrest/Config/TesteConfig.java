package com.filmes.APIrest.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.filmes.APIrest.ControllerRepository.Teste;

@Configuration
@Profile("teste")
public class TesteConfig {
	
	@Autowired
	private Teste teste;
	
	@Bean
	public void inicializar() {
		teste.inicializarBanco();
	}
}
