package com.critics.API.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.critics.API.Execptions.ObjectNotFoundExecption;
import com.critics.API.Filme.Filme;
import com.critics.API.Repository.FilmeRepository;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeRepository banco;
	
	public Filme findById(Long id) {
		Optional<Filme> obj = banco.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExecption("Filme não encontrado Id:" + id + 
				"Tipo: " + Filme.class.getName()));
	}
	
	public List<Filme> FindAll(){
		return banco.findAll();
	}
	
	public Filme cadastraFilme(Filme filme) {
		filme.setId(null);
		return banco.save(filme);
	}
	
	public void atualizaFilme(Filme filmeAntigo, Filme FilmeNovo) {
		FilmeNovo.setNome(filmeAntigo.getNome());
		FilmeNovo.setCategoria(filmeAntigo.getCategoria());
	}
	
	public Filme updateFilme(Filme filme) {
		Filme filmeNovo = new Filme();
		atualizaFilme(filme, filmeNovo);
		return banco.save(filmeNovo);
	}
	
	public void deletaFilme(Long Id) {
		banco.deleteById(Id);
	}
}
