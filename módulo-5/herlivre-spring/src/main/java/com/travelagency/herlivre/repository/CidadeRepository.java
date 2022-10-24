package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
