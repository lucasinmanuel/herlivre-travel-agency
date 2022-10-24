package com.travelagency.herlivre.repository;

import com.travelagency.herlivre.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooRepository extends JpaRepository<Voo,Long> {
}
