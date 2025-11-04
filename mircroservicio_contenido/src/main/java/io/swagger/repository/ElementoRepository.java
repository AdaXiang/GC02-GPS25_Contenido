package io.swagger.repository;

import io.swagger.model.ElementoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoRepository extends JpaRepository<ElementoEntity, Integer> {
}
