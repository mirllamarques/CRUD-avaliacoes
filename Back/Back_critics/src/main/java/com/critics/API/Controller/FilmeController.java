package com.critics.API.Controller;

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

import com.critics.API.Filme.Filme;
import com.critics.API.Service.FilmeService;

@RestController
@RequestMapping(value = "/Filmes")
public class FilmeController {

	@Autowired
	private FilmeService controle;
	
	@PostMapping
	public ResponseEntity<Filme> cadastraFilme(@RequestBody Filme filme){
		Filme obj = controle.cadastraFilme(filme);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/id")
	public ResponseEntity<Filme> deletaFilmes(@PathVariable Long id){
		controle.deletaFilme(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Filme> atualizaFilmes(@RequestBody Filme filme){
		Filme obj = controle.updateFilme(filme);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/id")
	public ResponseEntity<Filme> procuraId(@PathVariable Long id){
		Filme obj = controle.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<List<Filme>> procuraTodosFilmes(){
		List<Filme> filmes = controle.FindAll();
		return ResponseEntity.ok().body(filmes);
	}
	@GetMapping(value="/categoria")
	public ResponseEntity<List<Filme>> procuraCategoria(String categoria){
		List<Filme> filmes = controle.FindAll();
		for (Filme filme: filmes) {
			if (filme.getCategoria() != categoria) {
				filmes.remove(filme);
			}
		}
		return ResponseEntity.ok().body(filmes);
	}
}
