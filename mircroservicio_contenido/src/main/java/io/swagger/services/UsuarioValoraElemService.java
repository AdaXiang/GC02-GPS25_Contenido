package io.swagger.services;

import java.util.List;
import java.util.Optional;

import io.swagger.entity.UsuarioValoraElemEntity;
import io.swagger.repository.UsuarioValoraElemRepository;

public class UsuarioValoraElemService {
     private final UsuarioValoraElemRepository usuarioValoraElemRepository;

    public UsuarioValoraElemService(UsuarioValoraElemRepository usuarioValoraElemRepository) {
        this.usuarioValoraElemRepository = usuarioValoraElemRepository;
    }

    // GET all UsuarioValoraElem
    public List<UsuarioValoraElemEntity> getAllUsuarioValoraElems() {
        return usuarioValoraElemRepository.findAll();
    }

    // GET UsuarioValoraElem by ID 
    public Optional<UsuarioValoraElemEntity> getUsuarioValoraElemById(Integer id) {
        return usuarioValoraElemRepository.findById(id);
    }

    // CREATE UsuarioValoraElem
    public UsuarioValoraElemEntity createUsuarioValoraElem(UsuarioValoraElemEntity usuarioValoraElem) {
        return usuarioValoraElemRepository.save(usuarioValoraElem);
    }

    // UPDATE UsuarioValoraElem
    public UsuarioValoraElemEntity updateUsuarioValoraElem(Integer id, UsuarioValoraElemEntity usuarioValoraElemDetails) {
        return usuarioValoraElemRepository.findById(id)
                .map(usuarioValoraElem -> {
                    usuarioValoraElem.setValoracion(usuarioValoraElemDetails.getValoracion());
                    return usuarioValoraElemRepository.save(usuarioValoraElem);
                })
                .orElse(null);
    }

    // DELETE UsuarioValoraElem
    public void deleteUsuarioValoraElem(Integer id, UsuarioValoraElemEntity usuarioValoraElem) {
        usuarioValoraElemRepository.deleteById(id);
    }
}
