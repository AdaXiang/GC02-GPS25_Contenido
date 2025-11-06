package io.swagger.repository;

import io.swagger.model.CancionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends JpaRepository<CancionEntity, Integer> {
}
