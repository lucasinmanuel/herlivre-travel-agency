package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Long> {
}
