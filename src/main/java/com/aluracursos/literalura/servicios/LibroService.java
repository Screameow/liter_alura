package com.aluracursos.literalura.servicios;

import com.aluracursos.literalura.modelos.Autor;
import com.aluracursos.literalura.modelos.Datos;
import com.aluracursos.literalura.modelos.LenguajesLibro;
import com.aluracursos.literalura.modelos.Libro;
import com.aluracursos.literalura.repositorio.AutorRepository;
import com.aluracursos.literalura.repositorio.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private String URL_BASE = "https://gutendex.com/books/";
    private String URL_BUSQUEDA = "?search=";
    private ObtenerDatos obtenerDatos = new ObtenerDatos();

    @Autowired
    LibroRepository libroRepository;
    @Autowired
    AutorRepository autorRepository;


    private Datos getLibroPorNombre() {

        LibrosApi librosApi = new LibrosApi();
        Scanner scanner1 = new Scanner(System.in);

        System.out.println("¿Que libro deseas buscar?");
        String libroUsuario = scanner1.nextLine();
        System.out.println(URL_BASE + URL_BUSQUEDA + libroUsuario);
        String json = librosApi.consumoAPI(URL_BASE + URL_BUSQUEDA + libroUsuario);
        var datos = obtenerDatos.transformarDatos(json, Datos.class);
        System.out.println(datos);
        return datos;
    }

    public void buscarLibroPorNombre() {
        Datos datos = getLibroPorNombre();
        List<Libro> libros = datos.librosR().stream().map(libroR -> new Libro(libroR, autorRepository)).toList();
        libroRepository.saveAll(libros);
    }

    public void consultaLibrosRegistrados() {

        libroRepository.todosLosLibros().forEach(l -> {
            String autoresNombre = l.getAutores().stream().map(Autor::getNombre).collect(Collectors.joining(", "));
            System.out.println("\n--------------------\n" +
                    "Titulo del libro: " + l.getTitulo() + "\n"
                    + "Autor: " + autoresNombre + "\n"
                    + "Numero de descargas:" + l.getNumeroDeDescargas()
                    + "\n--------------------\n");
        });
    }

    public void librosPorIdioma() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Idiomas disponibles para consultar: " + Arrays.toString(LenguajesLibro.values()).replace("_", " ") + "\n ¿Que idioma deseas consultar?");
        String idiomaDeLibro = scanner.nextLine();
        var idiomaEspañol = LenguajesLibro.obtenerIdiomaEspañol(idiomaDeLibro);

        libroRepository.librosPorIdioma(idiomaEspañol).forEach(l -> System.out.println(l.getTitulo() + " " + l.getIdioma()));

    }
}

