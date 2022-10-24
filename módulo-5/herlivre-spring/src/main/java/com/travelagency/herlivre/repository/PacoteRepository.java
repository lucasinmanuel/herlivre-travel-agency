package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.Pacote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote,Long> {
}
