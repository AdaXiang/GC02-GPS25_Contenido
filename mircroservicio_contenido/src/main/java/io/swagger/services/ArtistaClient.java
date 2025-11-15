package io.swagger.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.swagger.model.Contenido;
import io.swagger.model.Artista;

@Service
public class ArtistaClient {

    private String usuariosBaseUrl = "http://localhost:3000/api/usuarios";

    private final RestTemplate restTemplate = new RestTemplate();

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
            c.setNombre((String) art.get("nombre"));
            c.setDescripcion((String) art.get("descripcion"));
            c.setNumventas((Integer) art.getOrDefault("numVentas", 0));
            c.setValoracion((Integer) art.getOrDefault("valoracion", 0));
            c.setNombre((String) art.get("nombreFoto"));
            c.setTipo(0); // 0 = artista
            c.setPrecio(null); // artistas no tienen precio

            artistas.add(c);
        }

        return artistas;
    }

    public Artista obtenerArtista(Integer idArtista) {
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

