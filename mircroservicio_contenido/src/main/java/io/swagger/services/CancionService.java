package io.swagger.services;

import io.swagger.entity.CancionEntity;
import io.swagger.repository.CancionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {

    @Autowired
    private final CancionRepository cancionRepository;

    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<CancionEntity> getAll() {
        return cancionRepository.findAll();
    }

    public Optional<CancionEntity> getById(Integer id) {
        return cancionRepository.findById(id);
    }

    public CancionEntity save(CancionEntity elemento) {
        return cancionRepository.save(elemento);
    }

    public void delete(Integer id) {
        cancionRepository.deleteById(id);
    }
}

