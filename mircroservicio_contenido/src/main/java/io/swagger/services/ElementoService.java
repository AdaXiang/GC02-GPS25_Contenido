package io.swagger.services;

import io.swagger.model.ElementoEntity;
import io.swagger.repository.ElementoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementoService {

    @Autowired
    private final ElementoRepository elementoRepository;

    public ElementoService(ElementoRepository elementoRepository) {
        this.elementoRepository = elementoRepository;
    }

    public List<ElementoEntity> getAll() {
        return elementoRepository.findAll();
    }

    public Optional<ElementoEntity> getById(Integer id) {
        return elementoRepository.findById(id);
    }

    public ElementoEntity save(ElementoEntity elemento) {
        return elementoRepository.save(elemento);
    }

    public void delete(Integer id) {
        elementoRepository.deleteById(id);
    }
}

