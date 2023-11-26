package com.uce.edu.transferencia.service;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public CuentaBancaria buscar(String numero);
	public void guardar(CuentaBancaria ctaB);
	public void actualizar(CuentaBancaria ctaB);
	public void eliminar(String numero);
}
