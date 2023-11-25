package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@SpringBootApplication
public class Pa2U1P5PsApplication implements CommandLineRunner{
	@Autowired
	private Materia materia;
	@Autowired
	private IMateriaService iMateriaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.materia.setCodigo("M1");
		this.materia.setNombre("P.Avanzada");
		this.materia.setNumeroCreditos(10);
		
		this.iMateriaService.registrar(materia);

		System.out.println("Reporte inicio");
		List<Materia> reporte = this.iMateriaService.buscarTodos();
		for (Materia mate: reporte) {
			System.out.println(mate);
		}

		Materia mate = this.iMateriaService.buscar("M1");
		System.out.println(mate);

		mate.setNumeroCreditos(20);

		this.iMateriaService.actualizar(mate);

		Materia mate2 = this.iMateriaService.buscar("M1");
		System.out.println(mate2);

		this.iMateriaService.eliminar("M1");

		mate2 = this.iMateriaService.buscar("M1");
		System.out.println(mate2);
		
	}
}
