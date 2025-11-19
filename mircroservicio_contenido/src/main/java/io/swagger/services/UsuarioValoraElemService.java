package io.swagger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;
import io.swagger.repository.UsuarioValoraElemRepository;

import io.swagger.entity.ElementoEntity;
import io.swagger.model.Usuario;
import io.swagger.model.UsuarioValoraElem;

import io.swagger.repository.ElementoRepository;


@Service
public class UsuarioValoraElemService {

    private final UsuarioValoraElemRepository usuarioValoraElemRepository;

    private final ElementoRepository elementoRepository;

    public UsuarioValoraElem converToModel(UsuarioValoraElemEntity entity) {
        UsuarioValoraElem uve = new UsuarioValoraElem();
        uve.setIduser(entity.getId().getIdUser());
        uve.setIdelem(entity.getId().getIdElem());
        uve.setValoracion(entity.getValoracion());
        return uve;
    }

    public UsuarioValoraElemService(UsuarioValoraElemRepository usuarioValoraElemRepository, ElementoRepository elementoRepository) {
        this.usuarioValoraElemRepository = usuarioValoraElemRepository;
        this.elementoRepository = elementoRepository;
    }

    // GET all
    public List<UsuarioValoraElemEntity> getAll() {
        return usuarioValoraElemRepository.findAll();
    }

    // GET by composite ID
    public Optional<UsuarioValoraElemEntity> getById(Integer idUser, Integer idElem) {
        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUser, idElem);
        return usuarioValoraElemRepository.findById(pk);
    }

    // CREATE (insert rating)
    public UsuarioValoraElemEntity create(Integer idUser, Integer idElem, Integer valoracion) {

        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUser, idElem);

        UsuarioValoraElemEntity entity = new UsuarioValoraElemEntity();
        entity.setId(pk);
        entity.setValoracion(valoracion);

        return usuarioValoraElemRepository.save(entity);
    }

    // UPDATE rating only
    public UsuarioValoraElemEntity update(Integer idUser, Integer idElem, Integer valoracion) {

        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUser, idElem);

        return usuarioValoraElemRepository.findById(pk)
                .map(e -> {
                    e.setValoracion(valoracion);
                    return usuarioValoraElemRepository.save(e);
                })
                .orElseThrow(() -> new RuntimeException("No existe valoración"));
    }

    // DELETE
    public void delete(UsuarioValoraElemId pk) {
        usuarioValoraElemRepository.deleteById(pk);
    }

    public UsuarioValoraElem convertToInputModel(UsuarioValoraElemEntity entity) {
        UsuarioValoraElem uve = new UsuarioValoraElem();
        
        uve.setIduser(entity.getId().getIdUser());
        uve.setIdelem(entity.getId().getIdElem());
        uve.setValoracion(entity.getValoracion());
        return uve;
    }
}

