package com.aluracursos.literalura.repositorio;

import com.aluracursos.literalura.modelos.Autor;
import com.aluracursos.literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre = ?1")
    List<Autor> findByNombreAndLibroId (String nombre, Long libroid);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre != 'Desconocido' ")
    List<Autor> findByNombre();

    @Query(value = "SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :fecha AND (a.fechaDeFallecimiento > :fecha OR a.fechaDeFallecimiento IS NULL)")
    List<Autor> findByFechaEnVida(Integer fecha);

}
