package com.uce.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5PsApplication implements CommandLineRunner {
	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IInventarioService inventarioService;
	@Autowired
	private IBodegaService bodegaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5PsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p1 = new Producto();
		p1.setCodigoBarras("123455");
		p1.setNombre("HP 15 Laptop");
		p1.setStock(0);
		this.iProductoService.guardar(p1);

		Producto p2 = new Producto();
		p2.setCodigoBarras("123456");
		p2.setNombre("DELL 15 Laptop");
		p2.setStock(0);
		this.iProductoService.guardar(p2);

		Bodega b1 = new Bodega();
		b1.setCapacidad(100);
		b1.setCodigo("121212");
		b1.setDireccion("America");
		b1.setNombre("Bodega1");
		this.bodegaService.guardar(b1);

		this.inventarioService.registrar("121212", "123455", 50);
		this.inventarioService.registrar("121212", "123456", 100);
		this.inventarioService.registrar("121212", "123455", 20);

		System.out.println("Reporte");
		Producto pro1 = this.iProductoService.buscar("123455");
		Producto pro2 = this.iProductoService.buscar("123456");
		System.out.println(pro1);
		System.out.println(pro2);

	}
}
