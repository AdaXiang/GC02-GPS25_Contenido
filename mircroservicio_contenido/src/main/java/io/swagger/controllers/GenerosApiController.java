package io.swagger.controllers;
import io.swagger.api.GenerosApi;
import io.swagger.services.GeneroService;
import io.swagger.model.GeneroEntity;
import io.swagger.model.Elemento;
import io.swagger.model.ElementoEntity;
import io.swagger.model.ErrorResponse;
import io.swagger.model.Genero;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class GenerosApiController implements GenerosApi {

    private static final Logger log = LoggerFactory.getLogger(GenerosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final GeneroService generoService; //nuevo

    @org.springframework.beans.factory.annotation.Autowired
    public GenerosApiController(ObjectMapper objectMapper, HttpServletRequest request, GeneroService generoService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.generoService = generoService; 
    }

    private Genero convertToModel(GeneroEntity entity) {
        Genero e = new Genero();
        e.setId(entity.getId());
        e.setNombre(entity.getNombre());
        return e;
    }

    // GET
    public ResponseEntity<List<Genero>> generosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género" ,schema=@Schema()) @Valid @RequestParam(value = "idGenero", required = false) Integer idGenero
        ,@Parameter(in = ParameterIn.QUERY, description = "Nombre del género" ,schema=@Schema()) @Valid @RequestParam(value = "nombre", required = false) String nombre) {
        List<GeneroEntity> entidades = generoService.getAllGeneros();
        List<Genero> generos = entidades.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
       
        return ResponseEntity.ok(generos);
    }

    // DELETE
    public ResponseEntity<Void> generosIdGeneroDelete(@Parameter(in = ParameterIn.PATH, description = "ID del género a eliminar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero) {
        generoService.deleteGenero(idGenero);
        return ResponseEntity.noContent().build();
    }

    // GET POR ID
    public ResponseEntity<Genero> generosIdGeneroGet(@Parameter(in = ParameterIn.PATH, description = "ID del género a consultar", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero) {
        Optional<GeneroEntity> opt = generoService.getGeneroById(idGenero);
        return opt.map(e -> ResponseEntity.ok(convertToModel(e)))
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT
    public ResponseEntity<Genero> generosIdGeneroPut(@Parameter(in = ParameterIn.PATH, description = "ID del género a actualizar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
        ,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body) {
        // TODO
        String accept = request.getHeader("Accept");
        try {
            // 🔹 Verificamos si el género existe
            var existenteOpt = generoService.getGeneroById(idGenero);
            if (existenteOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // 🔹 Actualizamos los datos
            var existente = existenteOpt.get();
            existente.setNombre(body.getNombre());

            var actualizado = generoService.updateGenero(idGenero, existente);

            // 🔹 Convertimos a modelo Swagger
            Genero genero = new Genero();
            genero.setId(actualizado.getId());
            genero.setNombre(actualizado.getNombre());

            // 🔹 Devolvemos la respuesta si el cliente acepta JSON
            if (accept != null && accept.contains("application/json")) {
                return ResponseEntity.ok(genero);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }

        } catch (Exception e) {
            log.error("Error al actualizar el género con id " + idGenero, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // POST /generos
    @Override
    public ResponseEntity<Genero> generosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body) {
        GeneroEntity entity = new GeneroEntity();
        entity.setNombre(body.getNombre());

        GeneroEntity saved = generoService.createGenero(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToModel(saved));
    }
}
