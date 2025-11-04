package io.swagger.controllers;

import io.swagger.api.ContenidosApi;
import io.swagger.model.Contenido;
import io.swagger.model.ErrorResponse;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")
@RestController
public class ContenidosApiController implements ContenidosApi {

    private static final Logger log = LoggerFactory.getLogger(ContenidosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ContenidosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Contenido>> contenidosGet(@Parameter(in = ParameterIn.QUERY, description = "ID del género por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "genero", required = false) Integer genero
,@Parameter(in = ParameterIn.QUERY, description = "ID del subgénero por el que se desea filtrar." ,schema=@Schema()) @Valid @RequestParam(value = "subgenero", required = false) Integer subgenero
,@Parameter(in = ParameterIn.QUERY, description = "Precio mínimo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomin", required = false) Float preciomin
,@Parameter(in = ParameterIn.QUERY, description = "Precio máximo del contenido." ,schema=@Schema()) @Valid @RequestParam(value = "preciomax", required = false) Float preciomax
,@Parameter(in = ParameterIn.QUERY, description = "Fecha mínima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamin", required = false) LocalDate fechamin
,@Parameter(in = ParameterIn.QUERY, description = "Fecha máxima de creación o publicación." ,schema=@Schema()) @Valid @RequestParam(value = "fechamax", required = false) LocalDate fechamax
) {
        // TODO
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Contenido>>(objectMapper.readValue("[ {\n  \"descripcion\" : \"Álbum debut de la banda SynthWave.\",\n  \"precio\" : 19.99,\n  \"tipo\" : 0,\n  \"esnovedad\" : true,\n  \"genero\" : {\n    \"id\" : 3,\n    \"nombre\" : \"Rock\"\n  },\n  \"fotoamazon\" : \"foto123.jpg\",\n  \"fechacrea\" : \"2025-10-06T14:00:00Z\",\n  \"numventas\" : 120,\n  \"valoracion\" : 4,\n  \"id\" : 1,\n  \"nombre\" : \"Electric Dreams\"\n}, {\n  \"descripcion\" : \"Álbum debut de la banda SynthWave.\",\n  \"precio\" : 19.99,\n  \"tipo\" : 0,\n  \"esnovedad\" : true,\n  \"genero\" : {\n    \"id\" : 3,\n    \"nombre\" : \"Rock\"\n  },\n  \"fotoamazon\" : \"foto123.jpg\",\n  \"fechacrea\" : \"2025-10-06T14:00:00Z\",\n  \"numventas\" : 120,\n  \"valoracion\" : 4,\n  \"id\" : 1,\n  \"nombre\" : \"Electric Dreams\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Contenido>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Contenido>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
