package com.aluracursos.literalura.modelos;

public enum LenguajesLibro {

    ESPAÑOL("es", "Español"),
    INGLES("en", "Ingles"),
    FRANCES("fr", "Frances"),
    PORTUGUES("pt", "Portugues"),
    LATIN("la", "Latin"),
    ALEMAN("de", "Aleman"),
    INGLES_MEDITERRANEO("enm", "Ingles mediterraneo");



    private String lenguajeGuten;
    private String lenguajesEspañol;

    private LenguajesLibro (String lenguajeGuten, String lenguajesEspañol){
        this.lenguajeGuten = lenguajeGuten;
        this.lenguajesEspañol = lenguajesEspañol;
    }

    public static LenguajesLibro obtenerIdioma (String idioma) {

        for (LenguajesLibro libro : LenguajesLibro.values()) {
            if (libro.lenguajeGuten.equalsIgnoreCase(idioma)) {
                return libro;
            }
        }
        throw new IllegalArgumentException("No se encontro idioma relacionado" + idioma);
    }

    public static LenguajesLibro obtenerIdiomaEspañol (String idioma) {

        for (LenguajesLibro libro : LenguajesLibro.values()){
            if (libro.lenguajesEspañol.equalsIgnoreCase(idioma)){
                return libro;
            }
        }
        throw new IllegalArgumentException("No se encontro el idioma relacionado" + idioma);
    }

}

