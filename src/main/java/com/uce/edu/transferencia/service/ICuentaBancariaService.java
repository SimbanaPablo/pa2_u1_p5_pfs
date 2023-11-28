package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public CuentaBancaria buscar(String numero);
	public void guardar(CuentaBancaria ctaB);
	public void actualizar(CuentaBancaria ctaB);
	public void eliminar(String numero);
	public void transferencia(String numeroCuenta,BigDecimal monto);
}
