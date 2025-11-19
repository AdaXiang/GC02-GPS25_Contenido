package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;

@Repository
public interface UsuarioValoraElemRepository extends JpaRepository<UsuarioValoraElemEntity, UsuarioValoraElemId>{
    
}
