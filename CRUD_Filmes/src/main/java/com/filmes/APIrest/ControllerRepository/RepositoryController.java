package com.filmes.APIrest.ControllerRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmes.APIrest.Excepetion.ObjectNotFoundExecption;
import com.filmes.APIrest.Filmes.Filmes;
import com.filmes.APIrest.Repository.Repository;

@Service
public class RepositoryController {
	
	@Autowired
	private Repository banco;
	
	public Filmes findById(Long id) {
		Optional<Filmes> obj = banco.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecption("Filme não encontrado Id:" + id + 
				"Tipo: " + Filmes.class.getName()));
	}
	
	public List<Filmes> FindAll(){
		return banco.findAll();
	}
	
	public Filmes cadastraFilme(Filmes filme) {
		filme.setId(null);
		return banco.save(filme);
	}
	
	public void atualizaFilme(Filmes filmeAntigo, Filmes FilmeNovo) {
		FilmeNovo.setNome(filmeAntigo.getNome());
		FilmeNovo.setCategoria(filmeAntigo.getCategoria());
	}
	
	public Filmes updateFilme(Filmes filme) {
		Filmes filmeNovo = new Filmes();
		atualizaFilme(filme, filmeNovo);
		return banco.save(filmeNovo);
	}
	
	public void deletaFilme(Long Id) {
		banco.deleteById(Id);
	}
	
}
