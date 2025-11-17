package io.swagger.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.OffsetDateTime;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.swagger.model.Contenido;
import io.swagger.model.Genero;
import io.swagger.model.Artista;

@Service
public class ArtistaClient {

    private String usuariosBaseUrl = "http://localhost:3000/api/usuarios";

    private final RestTemplate restTemplate = new RestTemplate();

    // Obtener la lista de artistas desde el microservicio externo para mapear a Contenido
    public List<Contenido> obtenerArtistas() {

        String url = usuariosBaseUrl + "/artistas";

        ResponseEntity<List<Map<String, Object>>> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );

        List<Map<String, Object>> artistasJson = response.getBody();

        // Convertimos los artistas del microservicio externo a Contenido
        List<Contenido> artistas = new ArrayList<>();

        for (Map<String, Object> art : artistasJson) {
            Contenido c = new Contenido();

            c.setId((Integer) art.get("id"));
            c.setNombre((String) art.get("nombreusuario"));
            // Conversión explícita de String a OffsetDateTime
            Object fechaObjeto = art.get("fecharegistro");
            if (fechaObjeto instanceof String) {
                try {
                    // La cadena debe estar en formato ISO 8601 (ej. 2025-11-15T19:46:07+01:00)
                    OffsetDateTime fecha = OffsetDateTime.parse((String) fechaObjeto);
                    c.setFechacrea(fecha);
                } catch (DateTimeParseException e) {
                    // Manejo de error si el microservicio envía un formato incorrecto
                    System.err.println("Error parseando la fecha de registro: " + fechaObjeto);
                }
            }
            c.setDescripcion((String) art.get("descripcion"));
            c.setNumventas((Integer) art.getOrDefault("oyentes", 0));
            c.setValoracion((Integer) art.getOrDefault("valoracion", 0));
            c.setPrecio(null); // artistas no tienen precio
            c.setEsnovedad((Boolean) art.get("esnovedad"));
            c.setNombre((String) art.get("nombreusuario"));
            c.setFotoamazon((String) art.get("rutafoto"));
            Genero g = new Genero();
            g.setId((Integer) art.get("genero"));
            c.setGenero(g);
            c.setTipo(0); // 0 = artista
            artistas.add(c);
        }

        return artistas;
    }

    public Artista obtenerArtistaPorId(Integer idArtista) {
        String url = usuariosBaseUrl + "/artistas/" + idArtista;

        ResponseEntity<Artista> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null,
                        Artista.class
                );

        return response.getBody();
    }
}

