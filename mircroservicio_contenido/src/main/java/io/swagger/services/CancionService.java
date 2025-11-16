package io.swagger.services;

import io.swagger.entity.CancionEntity;
import io.swagger.entity.ElementoEntity;
import io.swagger.model.Cancion;
import io.swagger.repository.CancionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CancionService {

    private final CancionRepository cancionRepository;

    private Cancion convertToModel(CancionEntity entity) {

        Cancion c = new Cancion();

        ElementoEntity e = entity.getElemento(); // Por @MapsId

        // Datos heredados de Elemento
        c.setId(e.getId());
        c.setNombre(e.getNombre());
        c.setDescripcion(e.getDescripcion());
        c.setPrecio(e.getPrecio());
        c.setNumventas(e.getNumventas());
        c.setValoracion(e.getValoracion());
        c.setEsnovedad(e.getEsnovedad());
        c.setUrlFoto(e.getUrlFoto());

        // Conversión fecha
        if (e.getFechacrea() != null) {
            org.threeten.bp.LocalDateTime fecha =
                    org.threeten.bp.LocalDateTime.of(
                            e.getFechacrea().getYear(),
                            e.getFechacrea().getMonthValue(),
                            e.getFechacrea().getDayOfMonth(),
                            e.getFechacrea().getHour(),
                            e.getFechacrea().getMinute(),
                            e.getFechacrea().getSecond()
                    );
            c.setFechacrea(fecha.atOffset(org.threeten.bp.ZoneOffset.UTC));
        }

        // Datos propios de Cancion
        c.setIdElemento(entity.getId());
        c.setNombreAudio(entity.getNombreAudio());
        c.setNumRep(entity.getNumRep());
        c.setIdAlbum(entity.getAlbum() != null ? entity.getAlbum().getId() : null);

        return c;
    }


    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<Cancion> getAll() {
        return cancionRepository.findAll()
                .stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }       

    public Cancion getById(Integer id) {
        CancionEntity entity = cancionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No existe"));

        return convertToModel(entity);
    }

    public CancionEntity save(CancionEntity elemento) {
        return cancionRepository.save(elemento);
    }

    public void delete(Integer id) {
        cancionRepository.deleteById(id);
    }
}

