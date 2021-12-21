package com.filmes.APIrest.ControllerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmes.APIrest.Filmes.Filmes;

@Service
public class Teste {
	@Autowired
	private RepositoryController controle;
	
	public void inicializarBanco() {
		Filmes filme = new Filmes(null,"Entre a espada e a cruz","Misterio");
		controle.cadastraFilme(filme);
	}
}
