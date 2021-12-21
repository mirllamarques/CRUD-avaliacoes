package com.filmes.APIrest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filmes.APIrest.Filmes.Filmes;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Filmes, Long>{

}
