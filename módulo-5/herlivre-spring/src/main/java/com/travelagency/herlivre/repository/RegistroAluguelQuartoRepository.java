package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.RegistroAluguelQuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroAluguelQuartoRepository extends JpaRepository<RegistroAluguelQuarto,Long> {
}
