package io.swagger.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CANCIONES")
public class CancionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "FECHACREA")
    private LocalDateTime fechacrea;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "URL_FOTO")
    private String urlFoto;

    @Column(name = "NUMVENTAS")
    private Integer numventas;

    @Column(name = "VALORACION")
    private Integer valoracion;

    @Column(name = "PRECIO")
    private Float precio;

    @Column(name = "ESNOVEDAD")
    private Boolean esnovedad;

    @Column(name = "ESALBUM")
    private Boolean esalbum;

    @Column(name = "GENERO_ID")
    private Integer idGenero;

    @Column(name = "ARTISTA_ID")
    private Integer idArtista;

    // Getters y Setters
    // ...
}
