package io.swagger.repository;
import io.swagger.model.Contenido;
import io.swagger.model.ElementoEntity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
@Repository
public interface ContenidoRepository extends JpaRepository<ElementoEntity, Integer>, JpaSpecificationExecutor<ElementoEntity> {
}
