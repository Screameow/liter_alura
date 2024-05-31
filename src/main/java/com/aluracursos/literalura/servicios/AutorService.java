package com.aluracursos.literalura.servicios;

import com.aluracursos.literalura.repositorio.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AutorService {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    AutorRepository autorRepository;

    public void listaDeAutores() {
        System.out.println("----- LISTA DE AUTORES -----");
        autorRepository.findByNombre().stream().forEach(l -> System.out.println(l.getNombre()));
        System.out.println("----------------------------");
    }

    public void listaDeAutoresPorFecha() {
        System.out.println("Consulta de autores en vida por año\nIngrese año a consultar: ");
        var fecha = scanner.nextInt();
        autorRepository.findByFechaEnVida(fecha).stream().forEach(a -> System.out.println("Nombre: " + a.getNombre() + " Estuvo en vida entre los años " + a.getFechaDeNacimiento() + " y " + a.getFechaDeFallecimiento()));
    }


}
