package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImp implements ITransferenciaService {
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;

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
		//2. Consultar saldo
		//3. validar saldo
		//4. restar monto
		//5. Actualizar cuenta origen
		//6. Buscar cuenta destino
		//7. Consultar  saldo
		//8. Sumar monto
		//9. actualizar cuenta destino
		//10. crear transferencia
		//6. 

	}

}
