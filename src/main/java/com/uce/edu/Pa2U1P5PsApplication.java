package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5PsApplication implements CommandLineRunner{
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService iCuentaBancariaService;
	
	
	/* DI por metodo (set)
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	public void setiTransferenciaService(ITransferenciaService iTransferenciaService) {
		this.iTransferenciaService = iTransferenciaService;
	}
	
	/* DI por constructor
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	public Pa2U1P5PsApplication(ITransferenciaService iTransService) {
		this.iTransferenciaService = iTransService;
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5PsApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1752245041");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaOrigen);
		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1743126709");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(100));
		this.iCuentaBancariaService.guardar(ctaDestino);
		
		this.iTransferenciaService.realizar("1234", "5678", new BigDecimal(30));
		int indice = 0;
		List<Transferencia> reporte = this.iTransferenciaService.mostrarTransferencias();
		for(Transferencia trans:reporte) {
			indice++;
			System.out.println(indice+":"+trans);
		}
		

		
		this.iCuentaBancariaService.transferencia("1234",new BigDecimal(100));
		
		CuentaBancaria ctaOrigen1 = this.iCuentaBancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		
		CuentaBancaria ctaDestino1 = this.iCuentaBancariaService.buscar("5678");
		System.out.println(ctaDestino1);
		

	}
}
