package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Genero;
import io.swagger.model.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import org.openapitools.jackson.nullable.JsonNullable;
import io.swagger.configuration.NotUndefined;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Artista
 */
@Validated
@NotUndefined
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-10-27T17:33:52.662194674Z[GMT]")


public class Artista extends Usuario  {
  @JsonProperty("esNovedad")

  private Boolean esNovedad = null;

  @JsonProperty("oyentes")

  private Integer oyentes = null;

  @JsonProperty("valoracion")

  private Float valoracion = null;

  @JsonProperty("genero")

  private Genero genero = null;


  public Artista esNovedad(Boolean esNovedad) { 

    this.esNovedad = esNovedad;
    return this;
  }

  /**
   * Indica si el artista es destacado o de reciente incorporación
   * @return esNovedad
   **/
  
  @Schema(example = "true", required = true, description = "Indica si el artista es destacado o de reciente incorporación")
  
  @NotNull
  public Boolean isEsNovedad() {  
    return esNovedad;
  }



  public void setEsNovedad(Boolean esNovedad) { 

    this.esNovedad = esNovedad;
  }

  public Artista oyentes(Integer oyentes) { 

    this.oyentes = oyentes;
    return this;
  }

  /**
   * Cantidad total de oyentes del artista
   * minimum: 0
   * @return oyentes
   **/
  
  @Schema(example = "15420", required = true, description = "Cantidad total de oyentes del artista")
  
  @NotNull
@Min(0)  public Integer getOyentes() {  
    return oyentes;
  }



  public void setOyentes(Integer oyentes) { 

    this.oyentes = oyentes;
  }

  public Artista valoracion(Float valoracion) { 

    this.valoracion = valoracion;
    return this;
  }

  /**
   * Valoración promedio del artista (de 0.0 a 5.0)
   * minimum: 0
   * maximum: 5
   * @return valoracion
   **/
  
  @Schema(example = "3.5", required = true, description = "Valoración promedio del artista (de 0.0 a 5.0)")
  
  @NotNull
@DecimalMin("0") @DecimalMax("5")   public Float getValoracion() {  
    return valoracion;
  }



  public void setValoracion(Float valoracion) { 

    this.valoracion = valoracion;
  }

  public Artista genero(Genero genero) { 

    this.genero = genero;
    return this;
  }

  /**
   * Get genero
   * @return genero
   **/
  
  @Schema(required = true, description = "")
  
@Valid
  @NotNull
  public Genero getGenero() {  
    return genero;
  }



  public void setGenero(Genero genero) { 

    this.genero = genero;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artista artista = (Artista) o;
    return Objects.equals(this.esNovedad, artista.esNovedad) &&
        Objects.equals(this.oyentes, artista.oyentes) &&
        Objects.equals(this.valoracion, artista.valoracion) &&
        Objects.equals(this.genero, artista.genero) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(esNovedad, oyentes, valoracion, genero, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Artista {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    esNovedad: ").append(toIndentedString(esNovedad)).append("\n");
    sb.append("    oyentes: ").append(toIndentedString(oyentes)).append("\n");
    sb.append("    valoracion: ").append(toIndentedString(valoracion)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
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
