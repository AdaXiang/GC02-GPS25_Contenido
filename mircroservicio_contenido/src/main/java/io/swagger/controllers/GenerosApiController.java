package io.swagger.controllers;
import io.swagger.api.GenerosApi;
import io.swagger.services.GeneroService;
import io.swagger.model.GeneroEntity;

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

    public ResponseEntity<List<Genero>> generosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género" ,schema=@Schema()) @Valid @RequestParam(value = "idGenero", required = false) Integer idGenero
,@Parameter(in = ParameterIn.QUERY, description = "Nombre del género" ,schema=@Schema()) @Valid @RequestParam(value = "nombre", required = false) String nombre
) {
        // TODO
        String accept = request.getHeader("Accept");

        try{
            List<GeneroEntity> entidades = generoService.getAllGeneros();          

            //Convertir las entidades JPA a los DTO Genero del modelo swagger
            List<Genero> generos = entidades.stream().map(entidad -> {
                Genero g = new Genero();
                g.setId(entidad.getId());
                g.setNombre(entidad.getNombre());
                return g;
            }).collect(Collectors.toList());

            //Devolver la respuesta en JSON solo si el cliente lo acepta
            if (accept != null && accept.contains("application/json")) {
                return ResponseEntity.ok(generos);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();       
            }
        } catch (Exception e){
            log.error("Error al obtener géneros", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> generosIdGeneroDelete(@Parameter(in = ParameterIn.PATH, description = "ID del género a eliminar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
) {
        // TODO
        try {
            // 🔹 Verificamos si existe el género
            var existente = generoService.getGeneroById(idGenero);
            if (existente.isEmpty()) {
                // Si no existe → 404 Not Found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // 🔹 Eliminamos
            generoService.deleteGenero(idGenero);

            // 🔹 Respuesta 204 No Content (correcto para DELETE)
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            log.error("Error al eliminar el género con id " + idGenero, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Genero> generosIdGeneroGet(@Parameter(in = ParameterIn.PATH, description = "ID del género a consultar", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
) {
        // TODO

        String accept = request.getHeader("Accept");

        try {
            var GeneroEntityOpt = generoService.getGeneroById(idGenero);

            if(GeneroEntityOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            // 🔹 Convertir la entidad JPA al modelo Swagger
            var entidad = GeneroEntityOpt.get();
            Genero genero = new Genero();
            genero.setId(entidad.getId());
            genero.setNombre(entidad.getNombre());
    
            if (accept != null && accept.contains("application/json")) {
                return ResponseEntity.ok(genero);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
        }catch (Exception e) {
            log.error("Error al obtener el género con id " + idGenero, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    public ResponseEntity<Genero> generosIdGeneroPut(@Parameter(in = ParameterIn.PATH, description = "ID del género a actualizar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body
) {
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

    public ResponseEntity<Genero> generosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body
) {
        // TODO
        String accept = request.getHeader("Accept");

        try {
            var entidad = new GeneroEntity();
            entidad.setNombre(body.getNombre());

            // guardar en bd
            var guardado = generoService.createGenero(entidad);

            //Convertirlo a swagger
            Genero genero = new Genero();
            genero.setId(guardado.getId());
            genero.setNombre(guardado.getNombre());

            if (accept != null && accept.contains("application/json")) {
                return new ResponseEntity<>(genero, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }

        } catch (Exception e) {
            log.error("Error al crear un nuevo género", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
