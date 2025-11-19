package io.swagger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.entity.UsuarioValoraElemId;
import io.swagger.repository.UsuarioValoraElemRepository;

@Service
public class UsuarioValoraElemService {

    private final UsuarioValoraElemRepository usuarioValoraElemRepository;

    public UsuarioValoraElemService(UsuarioValoraElemRepository usuarioValoraElemRepository) {
        this.usuarioValoraElemRepository = usuarioValoraElemRepository;
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
}
