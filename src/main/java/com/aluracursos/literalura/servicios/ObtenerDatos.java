package com.aluracursos.literalura.servicios;

import com.aluracursos.literalura.modelos.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObtenerDatos implements IObtenerDatos {

    ObjectMapper objectMapper = new ObjectMapper();


    //Se modifico el objectMapper para identificar las listas de autores vacias y agregarlos a la DB
    public Datos transformarDatos(String json, Class<Datos> clazz) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            Datos datos = mapper.readValue(json, clazz);
            for (LibroR libro : datos.librosR()) {
                if (libro.autores().isEmpty()) {
                    AutorR autorDesconocido = new AutorR("Desconocido", null, null);
                    libro.autores().add(autorDesconocido);
                }
            }
                return datos;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

