package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.Comprovante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprovanteRepository extends JpaRepository<Comprovante,Long> {
}
