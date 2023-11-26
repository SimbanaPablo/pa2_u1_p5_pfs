package com.uce.edu.transferencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImp implements ICuentaBancariaService {
	
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iCuentaBancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria ctaB) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.insertar(ctaB);

	}

	@Override
	public void actualizar(CuentaBancaria ctaB) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.actualizar(ctaB);

	}

	@Override
	public void eliminar(String numero) {
		// TODO Auto-generated method stub
		this.iCuentaBancariaRepository.eliminar(numero);

	}

}
