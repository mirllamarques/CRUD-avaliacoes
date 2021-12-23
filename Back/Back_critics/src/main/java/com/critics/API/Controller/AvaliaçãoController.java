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

import com.critics.API.Avaliação.Avaliação;
import com.critics.API.Service.AvaliaçãoService;

@RestController
@RequestMapping(value = "/Avaliações")
public class AvaliaçãoController {
	@Autowired
	private AvaliaçãoService controle;
	
	@PostMapping
	public ResponseEntity<Avaliação> cadastraFilme(@RequestBody Avaliação avaliação){
		Avaliação obj = controle.cadastraAvaliação(avaliação);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value="/idAvaliação")
	public ResponseEntity<Avaliação> deletaComentario(@PathVariable Long id){
		controle.deletaAvaliação(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<Avaliação> atualizaFilmes(@RequestBody Avaliação avaliação){
		Avaliação obj = controle.updateAvaliação(avaliação);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/ComentariosFilme")
	public ResponseEntity<List<Avaliação>> procuraId(@RequestBody String filme){
		List<Avaliação> obj = controle.findByFilme(filme);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<List<Avaliação>> procuraTodasAvaliações(){
		List<Avaliação> avaliações = controle.FindAll();
		return ResponseEntity.ok().body(avaliações);
	}
}
