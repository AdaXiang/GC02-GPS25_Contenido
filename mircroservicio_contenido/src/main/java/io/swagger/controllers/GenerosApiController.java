package io.swagger.controllers;

import io.swagger.api.GenerosApi;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class GenerosApiController implements GenerosApi {

    private static final Logger log = LoggerFactory.getLogger(GenerosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GenerosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Genero>> generosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género" ,schema=@Schema()) @Valid @RequestParam(value = "idGenero", required = false) Integer idGenero
,@Parameter(in = ParameterIn.QUERY, description = "Nombre del género" ,schema=@Schema()) @Valid @RequestParam(value = "nombre", required = false) String nombre
) {
        // TODO
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Genero>>(objectMapper.readValue("[ {\n  \"id\" : 3,\n  \"nombre\" : \"Rock\"\n}, {\n  \"id\" : 3,\n  \"nombre\" : \"Rock\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Genero>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Genero>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> generosIdGeneroDelete(@Parameter(in = ParameterIn.PATH, description = "ID del género a eliminar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
) {
        // TODO
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Genero> generosIdGeneroGet(@Parameter(in = ParameterIn.PATH, description = "ID del género a consultar", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
) {
        // TODO
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Genero>(objectMapper.readValue("{\n  \"id\" : 3,\n  \"nombre\" : \"Rock\"\n}", Genero.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Genero>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Genero>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Genero> generosIdGeneroPut(@Parameter(in = ParameterIn.PATH, description = "ID del género a actualizar.", required=true, schema=@Schema()) @PathVariable("idGenero") Integer idGenero
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body
) {
        // TODO
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Genero>(objectMapper.readValue("{\n  \"id\" : 3,\n  \"nombre\" : \"Rock\"\n}", Genero.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Genero>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Genero>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Genero> generosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Genero body
) {
        // TODO
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Genero>(objectMapper.readValue("{\n  \"id\" : 3,\n  \"nombre\" : \"Rock\"\n}", Genero.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Genero>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Genero>(HttpStatus.NOT_IMPLEMENTED);
    }

}
