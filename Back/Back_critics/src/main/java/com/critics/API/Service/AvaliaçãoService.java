package com.critics.API.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.critics.API.Avaliação.Avaliação;
import com.critics.API.Repository.AvaliaçãoRepository;

@Service
public class AvaliaçãoService {
	
	@Autowired
	private AvaliaçãoRepository banco;
	
	public List<Avaliação> findByFilme(String nomeFilme) {
		List<Avaliação> obj = FindAll();
		if (obj.isEmpty()) {
			return null;
		}
		for (Avaliação avaliação: obj) {
			if (avaliação.getFilme().getNome() != nomeFilme) {
				obj.remove(avaliação);
			}
		}
		
		return obj;
	}
	public List<Avaliação> FindAll(){
		return banco.findAll();
	}
	
	public Avaliação cadastraAvaliação(Avaliação avaliação) {
		avaliação.setId(null);
		return banco.save(avaliação);
	}
	
	private void atualizaComentario(Avaliação comentarioAntigo, Avaliação comentarioNovo) {
		comentarioNovo.setComentario(comentarioAntigo.getComentario());
	}
	
	public Avaliação updateAvaliação(Avaliação avaliação) {
		Avaliação avaliaçãoNova = new Avaliação();
		atualizaComentario(avaliação, avaliaçãoNova);
		return banco.save(avaliaçãoNova);
	}
	
	public void deletaAvaliação(Long Id) {
		banco.deleteById(Id);
	}
}
