package com.aluracursos.literalura.servicios;

import com.aluracursos.literalura.modelos.Datos;

public interface IObtenerDatos {

// <T> T transformarDatos(String json, Class<T> clase);
 Datos transformarDatos(String json, Class<Datos> datosClass);

}
