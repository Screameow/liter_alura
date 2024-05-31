package com.aluracursos.literalura.repositorio;
import com.aluracursos.literalura.modelos.Autor;
import com.aluracursos.literalura.modelos.LenguajesLibro;
import com.aluracursos.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query (value = "SELECT * FROM libro", nativeQuery = true)
    List<Libro> todosLosLibros();

    @Query (value = "SELECT l FROM Libro l WHERE l.idioma = :lenguajesLibro")
    List<Libro> librosPorIdioma(LenguajesLibro lenguajesLibro);

}
