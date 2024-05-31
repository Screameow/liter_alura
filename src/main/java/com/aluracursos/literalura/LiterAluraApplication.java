package com.aluracursos.literalura;

import com.aluracursos.literalura.principal.Principal;
import com.aluracursos.literalura.repositorio.AutorRepository;
import com.aluracursos.literalura.repositorio.LibroRepository;
import com.aluracursos.literalura.servicios.AutorService;
import com.aluracursos.literalura.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Autowired
	private LibroService libroService;
	@Autowired
	private AutorService autorService;

	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(libroService, autorService);
		principal.principal();
	}
}
