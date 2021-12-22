package com.filmes.APIrest.Avaliacao;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.filmes.APIrest.Filmes.Filmes;

public class Avaliações {
	
	@Id
	private long id;
	private Filmes nomeFilme;
	private String comentario;
	
	public Avaliações(long id, Filmes Filme, String comentario) {
		this.id = id;
		this.nomeFilme = Filme;
		this.comentario = comentario;
	}
	
	public Avaliações() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliações other = (Avaliações) obj;
		return id == other.id;
	}
	public Filmes getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(Filmes nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
}
