package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Artista;
import io.swagger.model.Genero;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ElementoInput
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class ElementoInput   {
  @JsonProperty("nombre")

  private String nombre = null;

  @JsonProperty("descripcion")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String descripcion = null;

  @JsonProperty("urlFoto")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private String urlFoto = null;

  @JsonProperty("precio")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Float precio = null;

  @JsonProperty("esnovedad")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean esnovedad = null;

  @JsonProperty("esalbum")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Boolean esalbum = null;

  @JsonProperty("genero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero genero = null;

  @JsonProperty("subgenero")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Genero subgenero = null;

  @JsonProperty("artista")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Artista artista = null;

  @JsonProperty("tipoContenido")

  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  @JsonSetter(nulls = Nulls.FAIL)    // FAIL setting if the value is null
  private Integer tipoContenido = null;


  public ElementoInput nombre(String nombre) { 

    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
   **/
  
  @Schema(example = "Electric Dreams", required = true, description = "")
  
  @NotNull
  public String getNombre() {  
    return nombre;
  }



  public void setNombre(String nombre) { 

    this.nombre = nombre;
  }

  public ElementoInput descripcion(String descripcion) { 

    this.descripcion = descripcion;
    return this;
  }

  /**
   * Get descripcion
   * @return descripcion
   **/
  
  @Schema(example = "Álbum debut de la banda SynthWave", description = "")
  
  public String getDescripcion() {  
    return descripcion;
  }



  public void setDescripcion(String descripcion) { 
    this.descripcion = descripcion;
  }

  public ElementoInput urlFoto(String urlFoto) { 

    this.urlFoto = urlFoto;
    return this;
  }

  /**
   * url de la foto
   * @return urlFoto
   **/
  
  @Schema(example = "amazon", description = "url de la foto")
  
  public String getUrlFoto() {  
    return urlFoto;
  }



  public void setUrlFoto(String urlFoto) { 
    this.urlFoto = urlFoto;
  }

  public ElementoInput precio(Float precio) { 

    this.precio = precio;
    return this;
  }

  /**
   * Get precio
   * @return precio
   **/
  
  @Schema(example = "19.99", description = "")
  
  public Float getPrecio() {  
    return precio;
  }



  public void setPrecio(Float precio) { 
    this.precio = precio;
  }

  public ElementoInput esnovedad(Boolean esnovedad) { 

    this.esnovedad = esnovedad;
    return this;
  }

  /**
   * Get esnovedad
   * @return esnovedad
   **/
  
  @Schema(example = "true", description = "")
  
  public Boolean isEsnovedad() {  
    return esnovedad;
  }



  public void setEsnovedad(Boolean esnovedad) { 
    this.esnovedad = esnovedad;
  }

  public ElementoInput esalbum(Boolean esalbum) { 

    this.esalbum = esalbum;
    return this;
  }

  /**
   * Get esalbum
   * @return esalbum
   **/
  
  @Schema(example = "false", description = "")
  
  public Boolean isEsalbum() {  
    return esalbum;
  }



  public void setEsalbum(Boolean esalbum) { 
    this.esalbum = esalbum;
  }

  public ElementoInput genero(Genero genero) { 

    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
   **/
  
  @Schema(description = "")
  
@Valid
  public Genero getGenero() {  
    return genero;
  }



  public void setGenero(Genero genero) { 
    this.genero = genero;
  }

  public ElementoInput subgenero(Genero subgenero) { 

    this.subgenero = subgenero;
    return this;
  }

  /**
   * Get subgenero
   * @return subgenero
   **/
  
  @Schema(description = "")
  
@Valid
  public Genero getSubgenero() {  
    return subgenero;
  }



  public void setSubgenero(Genero subgenero) { 
    this.subgenero = subgenero;
  }

  public ElementoInput artista(Artista artista) { 

    this.artista = artista;
    return this;
  }

  /**
   * Get artista
   * @return artista
   **/
  
  @Schema(description = "")
  
@Valid
  public Artista getArtista() {  
    return artista;
  }



  public void setArtista(Artista artista) { 
    this.artista = artista;
  }

  public ElementoInput tipoContenido(Integer tipoContenido) { 

    this.tipoContenido = tipoContenido;
    return this;
  }

  /**
   * Get tipoContenido
   * @return tipoContenido
   **/
  
  @Schema(example = "2", description = "")
  
  public Integer getTipoContenido() {  
    return tipoContenido;
  }



  public void setTipoContenido(Integer tipoContenido) { 
    this.tipoContenido = tipoContenido;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementoInput elementoInput = (ElementoInput) o;
    return Objects.equals(this.nombre, elementoInput.nombre) &&
        Objects.equals(this.descripcion, elementoInput.descripcion) &&
        Objects.equals(this.urlFoto, elementoInput.urlFoto) &&
        Objects.equals(this.precio, elementoInput.precio) &&
        Objects.equals(this.esnovedad, elementoInput.esnovedad) &&
        Objects.equals(this.esalbum, elementoInput.esalbum) &&
        Objects.equals(this.genero, elementoInput.genero) &&
        Objects.equals(this.subgenero, elementoInput.subgenero) &&
        Objects.equals(this.artista, elementoInput.artista) &&
        Objects.equals(this.tipoContenido, elementoInput.tipoContenido);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre, descripcion, urlFoto, precio, esnovedad, esalbum, genero, subgenero, artista, tipoContenido);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ElementoInput {\n");
    
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
    sb.append("    urlFoto: ").append(toIndentedString(urlFoto)).append("\n");
    sb.append("    precio: ").append(toIndentedString(precio)).append("\n");
    sb.append("    esnovedad: ").append(toIndentedString(esnovedad)).append("\n");
    sb.append("    esalbum: ").append(toIndentedString(esalbum)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    subgenero: ").append(toIndentedString(subgenero)).append("\n");
    sb.append("    artista: ").append(toIndentedString(artista)).append("\n");
    sb.append("    tipoContenido: ").append(toIndentedString(tipoContenido)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
