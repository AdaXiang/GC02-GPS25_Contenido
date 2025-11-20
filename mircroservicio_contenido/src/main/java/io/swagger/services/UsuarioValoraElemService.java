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

    public UsuarioValoraElemService(UsuarioValoraElemRepository usuarioValoraElemRepository) {
        this.usuarioValoraElemRepository = usuarioValoraElemRepository;
    }

    // GET all
    public List<UsuarioValoraElemEntity> getAll() {
        return usuarioValoraElemRepository.findAll();
    }

    // GET espfecífico
    public Optional<UsuarioValoraElemEntity> getById(Integer idUser, Integer idElem) {
        UsuarioValoraElemId pk = new UsuarioValoraElemId(idUser, idElem);
        return usuarioValoraElemRepository.findById(pk);
    }

    // GET by idelem
    public List<UsuarioValoraElemEntity> getByIdelem(Integer idelem) {
        return usuarioValoraElemRepository.findByIdIdElem(idelem);
    }


    // CREATE (insert rating)
    public UsuarioValoraElemEntity create(UsuarioValoraElemEntity uve) {
        return usuarioValoraElemRepository.save(uve);
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

