package io.swagger.controllers;

import io.swagger.api.UsuarioValoraElemApi;
import io.swagger.model.ErrorResponse;

import io.swagger.model.UsuarioValoraElem;
import io.swagger.services.UsuarioValoraElemService;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-11-19T10:28:12.285996221Z[GMT]")
@RestController
public class UsuarioValoraElemApiController implements UsuarioValoraElemApi {

    private static final Logger log = LoggerFactory.getLogger(UsuarioValoraElemApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final UsuarioValoraElemService usuarioValoraElemService;

    @org.springframework.beans.factory.annotation.Autowired
    public UsuarioValoraElemApiController(ObjectMapper objectMapper, HttpServletRequest request, UsuarioValoraElemService usuarioValoraElemService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.usuarioValoraElemService = usuarioValoraElemService;
    }

    // GET /UsuarioValoraElem
    public ResponseEntity<List<UsuarioValoraElem>> usuarioValoraElemGet() {
    //    List<UsuarioValoraElem> lista = usuarioValoraElemService.getAllUsuarioValoraElems().stream().map(entity -> {
    //        UsuarioValoraElem model = new UsuarioValoraElem();
    //        model.setIduser(null);(entity.getId().getIdUser());
    //        model.setIdelem(entity.getId().getIdElem());
    //        model.setValoracion(entity.getValoracion());
    //        model.setComentario(entity.getComentario());
    //        if (entity.getFechaComentario() != null) {
    //            model.setFechaComentario(entity.getFechaComentario().toString());
    //        }
    //        return model;
    //    }).toList();
       return new ResponseEntity<List<UsuarioValoraElem>>(HttpStatus.OK);
    }

    // GET /UsuarioValoraElem/{idUsuario}/{idElemento}
    public ResponseEntity<Integer> usuarioValoraElemIdUsuarioIdElementoGet(@Parameter(in = ParameterIn.PATH, description = "ID del usuario", required=true, schema=@Schema()) @PathVariable("idUsuario") Integer idUsuario
,@Parameter(in = ParameterIn.PATH, description = "ID del elemento", required=true, schema=@Schema()) @PathVariable("idElemento") Integer idElemento) {
       

        return new ResponseEntity<Integer>(HttpStatus.NOT_IMPLEMENTED);
    }

    // POST /UsuarioValoraElem
    public ResponseEntity<UsuarioValoraElem> usuarioValoraElemPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsuarioValoraElem body) {
        
        return new ResponseEntity<UsuarioValoraElem>(HttpStatus.NOT_IMPLEMENTED);
    }

    // PUT /UsuarioValoraElem
    public ResponseEntity<UsuarioValoraElem> usuarioValoraElemPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody UsuarioValoraElem body) {
        
        return new ResponseEntity<UsuarioValoraElem>(HttpStatus.NOT_IMPLEMENTED);
    }

    // DELETE /UsuarioValoraElem/{idUsuario}/{idElemento}
    public ResponseEntity<Void> usuarioValoraElemIdUsuarioIdElementoDelete(@Parameter(in = ParameterIn.PATH, description = "ID del usuario", required=true, schema=@Schema()) @PathVariable("idUsuario") Integer idUsuario
,@Parameter(in = ParameterIn.PATH, description = "ID del elemento", required=true, schema=@Schema()) @PathVariable("idElemento") Integer idElemento) {
        
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
