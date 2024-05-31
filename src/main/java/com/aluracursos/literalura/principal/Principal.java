package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.modelos.Autor;
import com.aluracursos.literalura.modelos.Datos;
import com.aluracursos.literalura.modelos.LenguajesLibro;
import com.aluracursos.literalura.modelos.Libro;
import com.aluracursos.literalura.repositorio.AutorRepository;
import com.aluracursos.literalura.repositorio.LibroRepository;
import com.aluracursos.literalura.servicios.AutorService;
import com.aluracursos.literalura.servicios.LibroService;
import com.aluracursos.literalura.servicios.LibrosApi;
import com.aluracursos.literalura.servicios.ObtenerDatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {

    Scanner scanner = new Scanner(System.in);

    private LibroService libroService;
    private AutorService autorService;


    public Principal( LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void principal() {
        int respuesta = -1;

        while (respuesta != 0) {

            System.out.println("------------------------------");
            System.out.println("1 - Buscar libro por nombre");
            System.out.println("2 - Libros registrados");
            System.out.println("3 - Listar autores registrados");
            System.out.println("4 - Listar autores vivos en determinado año");
            System.out.println("5 - Listar libros por idioma");
            System.out.println("0 - Salir");
            System.out.println("------------------------------");

            respuesta = scanner.nextInt();

            switch (respuesta) {
                case 0:
                    System.out.println("Cerrando app...");
                    break;
                case 1:
                    libroService.buscarLibroPorNombre();
                    break;
                case 2:
                    libroService.consultaLibrosRegistrados();
                    break;
                case 3:
                    autorService.listaDeAutores();
                    break;
                case 4:
                    autorService.listaDeAutoresPorFecha();
                    break;
                case 5:
                    libroService.librosPorIdioma();
            }
        }
    }
}