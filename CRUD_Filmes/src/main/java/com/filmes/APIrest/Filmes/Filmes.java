package com.filmes.APIrest.Filmes;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Filmes {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String Nome;
	@Column
	private String categoria;
	
	public Filmes() {
		
	}
	public Filmes(Long id, String Nome, String categoria) {
		super();
		this.id = id;
		this.Nome = Nome;
		this.categoria = categoria;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
		Filmes other = (Filmes) obj;
		return Objects.equals(id, other.id);
	}
}
