package com.aluracursos.literalura.modelos;
import com.aluracursos.literalura.repositorio.AutorRepository;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Libro {

    @Id
    private Long id;

//    @Column(unique = true)
    private String titulo;
    private Integer numeroDeDescargas;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;

    @Enumerated(EnumType.STRING)
    private LenguajesLibro idioma;

    public Libro(LibroR libroR, AutorRepository autorRepository) {
        this.id = libroR.id();
        this.titulo = libroR.titulo();
        this.numeroDeDescargas = libroR.totalDeDescargas();
        this.idioma = LenguajesLibro.obtenerIdioma(libroR.idioma().get(0));
        this.autores = libroR.autores().stream().map(autorR -> {
            List<Autor> autorExistente = autorRepository.findByNombreAndLibroId(autorR.nombre(), this.id);
            if (!autorExistente.isEmpty()) {
                return autorExistente.get(0);
            } else {
                Autor nuevoAutor = new Autor(autorR);
                nuevoAutor.setLibro(this);
                return nuevoAutor;
            }
        }).toList();


        //bucle para que en cada instancia se mande la informacion mapeada de toda la clase Libro representada por "this"
        for (Autor autor : autores) {
            autor.setLibro(this);
        }
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Libro() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public LenguajesLibro getIdioma() {
        return idioma;
    }

    public void setIdioma(LenguajesLibro idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                ", autores=" + autores +
                ", idioma=" + idioma +
                '}';
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
        for (Autor autor : autores) {
            autor.setLibro(this);
    }
    }
}