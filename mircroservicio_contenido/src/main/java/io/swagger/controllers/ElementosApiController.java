package io.swagger.controllers;

import io.swagger.api.ElementosApi;
import io.swagger.model.Elemento;
import io.swagger.model.ElementoEntity;
import io.swagger.model.ElementoInput;
import io.swagger.model.*;
import io.swagger.model.ErrorResponse;
import io.swagger.services.ElementoService;
import java.util.Optional;

import org.threeten.bp.LocalDate;
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
public class ElementosApiController implements ElementosApi {

    private static final Logger log = LoggerFactory.getLogger(ElementosApiController.class);
    private final ElementoService elementoService;
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    private Elemento convertToModel(ElementoEntity entity) {
        Elemento e = new Elemento();
        e.setId(entity.getId());
        e.setNombre(entity.getNombre());
        e.setDescripcion(entity.getDescripcion());
        e.setPrecio(entity.getPrecio());
        e.setEsalbum(entity.getEsalbum());
        e.setEsnovedad(entity.getEsnovedad());
        e.setValoracion(entity.getValoracion());
        e.setNumventas(entity.getNumventas());
        e.setUrlFoto(entity.getUrlFoto());
        return e;
    }

    @org.springframework.beans.factory.annotation.Autowired
    public ElementosApiController(ElementoService elementoService, ObjectMapper objectMapper, HttpServletRequest request) {
        this.elementoService = elementoService;
        this.objectMapper = objectMapper;
        this.request = request;
    }

    // GET /elementos
    @Override
    public ResponseEntity<List<Elemento>> elementosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "genero", required = false) Integer genero
        ,@Parameter(in = ParameterIn.QUERY, description = "ID del subgénero por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "subgenero", required = false) Integer subgenero
        ,@Parameter(in = ParameterIn.QUERY, description = "Precio mínimo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomin", required = false) Float preciomin
        ,@Parameter(in = ParameterIn.QUERY, description = "Precio máximo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomax", required = false) Float preciomax
        ,@Parameter(in = ParameterIn.QUERY, description = "Fecha mínima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamin", required = false) LocalDate fechamin
        ,@Parameter(in = ParameterIn.QUERY, description = "Fecha máxima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamax", required = false) LocalDate fechamax) {
      
        List<ElementoEntity> entidades = elementoService.getAll();
        List<Elemento> elementos = entidades.stream()
        .filter(e -> preciomin == null || e.getPrecio() >= preciomin)
        .filter(e -> preciomax == null || e.getPrecio() <= preciomax)
        .filter(e -> genero == null || e.getGenero().equals(genero))
        .map(this::convertToModel)
        .collect(Collectors.toList());
        return ResponseEntity.ok(elementos);
    }

    // DELETE /elementos/{id}
    @Override
    public ResponseEntity<Void> elementosIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID del contenido que se desea eliminar", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        elementoService.delete(id);
        return ResponseEntity.noContent().build();

    }

    // GET /elementos/{id}
    @Override
    public ResponseEntity<Elemento> elementosIdGet(@Parameter(in = ParameterIn.PATH, description = "ID del contenido a consultar", required=true, schema=@Schema()) @PathVariable("id") Integer id) {
        Optional<ElementoEntity> opt = elementoService.getById(id);
        return opt.map(e -> ResponseEntity.ok(convertToModel(e)))
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /elementos
    @Override
    public ResponseEntity<Elemento> elementosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ElementoInput body) {
        ElementoEntity entity = new ElementoEntity();
        entity.setNombre(body.getNombre());
        //entity.setArtista(body.getArtista().getId());
        entity.setDescripcion(body.getDescripcion());
        entity.setPrecio(body.getPrecio());
        entity.setEsalbum(body.isEsalbum());
        entity.setEsnovedad(body.isEsnovedad());
        entity.setValoracion(0);
        entity.setNumventas(0);
        //entity.setGenero(body.getGenero().getId());
        entity.setUrlFoto(body.getUrlFoto());

        ElementoEntity saved = elementoService.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToModel(saved));
    }

    // PUT /elementos
    @Override
    public ResponseEntity<Elemento> elementosPut(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Elemento body) {
        Optional<ElementoEntity> opt = elementoService.getById(body.getId());
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        ElementoEntity entity = opt.get();
        if (body.getNombre() != null) entity.setNombre(body.getNombre());
        if (body.getDescripcion() != null) entity.setDescripcion(body.getDescripcion());
        if (body.getPrecio() != null) entity.setPrecio(body.getPrecio());
        if (body.isEsalbum() != null) entity.setEsalbum(body.isEsalbum());
        if (body.isEsnovedad() != null) entity.setEsnovedad(body.isEsnovedad());
        if (body.getValoracion() != null) entity.setValoracion(body.getValoracion());
        if (body.getNumventas() != null) entity.setNumventas(body.getNumventas());
        if (body.getUrlFoto() != null) entity.setUrlFoto(body.getUrlFoto());

        ElementoEntity updated = elementoService.save(entity);
        return ResponseEntity.ok(convertToModel(updated));
    }

}
