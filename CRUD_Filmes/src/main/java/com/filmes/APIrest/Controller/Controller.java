package com.filmes.APIrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.APIrest.ControllerRepository.RepositoryController;
import com.filmes.APIrest.Filmes.Filmes;


@RestController
@RequestMapping(value = "/Filmes")
public class Controller {
	
	@Autowired
	private RepositoryController controle;
	
	@PostMapping
	public ResponseEntity<Filmes> cadastraFilme(@RequestBody Filmes filme){
		Filmes obj = controle.cadastraFilme(filme);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/id")
	public ResponseEntity<Filmes> deletaFilmes(@PathVariable Long id){
		controle.deletaFilme(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Filmes> atualizaFilmes(@RequestBody Filmes filme){
		Filmes obj = controle.updateFilme(filme);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/id")
	public ResponseEntity<Filmes> procuraId(@PathVariable Long id){
		Filmes obj = controle.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<List<Filmes>> procuraTodosFilmes(){
		List<Filmes> filmes = controle.FindAll();
		return ResponseEntity.ok().body(filmes);
	}
	@GetMapping(value="/categoria")
	public ResponseEntity<List<Filmes>> procuraCategoria(String categoria){
		List<Filmes> filmes = controle.FindAll();
		for (Filmes filme: filmes) {
			if (filme.getCategoria() != categoria) {
				filmes.remove(filme);
			}
		}
		return ResponseEntity.ok().body(filmes);
	}
}
