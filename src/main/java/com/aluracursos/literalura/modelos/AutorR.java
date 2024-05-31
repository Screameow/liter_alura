package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorR(
        @JsonAlias("name")
        String nombre,
        @JsonAlias("birth_year")
        Integer fechaDeNacimiento,
        @JsonAlias("death_year")
        Integer fechaDeMuerte) {
}
