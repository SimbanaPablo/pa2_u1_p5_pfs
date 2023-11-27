package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImp implements ITransferenciaService {
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transf) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transf);
	}

	@Override
	public void actualizar(Transferencia transf) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transf);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);

	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//1. Buscar cuenta origen
		CuentaBancaria ctaOrigen = this.iCuentaBancariaRepository.seleccionar(numeroOrigen);
		//2. Consultar saldo
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		//3. validar saldo
		if(saldoOrigen.compareTo(monto)>=0) {
		//4. restar monto	
			BigDecimal nuevoSaldoOrigen = saldoOrigen.subtract(monto);
		//5. Actualizar cuenta origen
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.iCuentaBancariaRepository.actualizar(ctaOrigen);
		//6. Buscar cuenta destino
			CuentaBancaria ctaDestino = this.iCuentaBancariaRepository.seleccionar(numeroDestino);
		//7. Consultar  saldo
			BigDecimal saldoDestino = ctaDestino.getSaldo();
		//8. Sumar monto
			BigDecimal nuevoSaldoDestino = saldoDestino.add(monto);
		//9. actualizar cuenta destino
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.iCuentaBancariaRepository.actualizar(ctaDestino);
		//10. crear transferencia
			Transferencia transferencia = new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero("121212121");
			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("Transferencia realizada con exito");
			this.iTransferenciaRepository.insertarTransferencia();
			
			
		}else{
			System.out.println("Saldo no disponible");
		}

	}

	@Override
	public Integer buscarTodasTransferencias() {
		return this.iTransferenciaRepository.seleccionarTodasTransferencias();
	}

}
