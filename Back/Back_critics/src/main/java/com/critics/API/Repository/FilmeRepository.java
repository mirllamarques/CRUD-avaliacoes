package com.critics.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.critics.API.Filme.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
