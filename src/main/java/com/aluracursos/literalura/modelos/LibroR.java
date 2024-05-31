package com.aluracursos.literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroR(
        @JsonAlias("id")
        Long id,
        @JsonAlias("title")
        String titulo,
        @JsonAlias("download_count")
        Integer totalDeDescargas,
        @JsonAlias("authors")
        List<AutorR> autores,
        @JsonAlias("languages")
        List<String> idioma
){
}
