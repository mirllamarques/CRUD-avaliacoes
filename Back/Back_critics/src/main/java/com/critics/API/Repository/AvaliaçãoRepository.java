package com.critics.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.critics.API.Avaliação.Avaliação;

@Repository
public interface AvaliaçãoRepository extends JpaRepository<Avaliação, Long> {

}
