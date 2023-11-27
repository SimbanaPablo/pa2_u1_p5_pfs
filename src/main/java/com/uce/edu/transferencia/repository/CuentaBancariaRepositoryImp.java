package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
@Repository
public class CuentaBancariaRepositoryImp implements ICuentaBancariaRepository {

	public static List<CuentaBancaria> base = new ArrayList<CuentaBancaria>();
	@Override
	public CuentaBancaria seleccionar(String numero) {
		for(CuentaBancaria cuenta: base) {
			if(cuenta.getNumero().equals(numero)) {
				CuentaBancaria cta = new CuentaBancaria();
				cta.setCedulaPropietario(cuenta.getCedulaPropietario());
				cta.setNumero(cuenta.getNumero());
				cta.setSaldo(cuenta.getSaldo());
				return cuenta;
			}
		}
		return null;
	}

	@Override
	public void insertar(CuentaBancaria ctaB) {
		base.add(ctaB);
		
	}

	@Override
	public void actualizar(CuentaBancaria ctaB) {
		this.eliminar(ctaB.getNumero());
		this.insertar(ctaB);

	}

	@Override
	public void eliminar(String numero) {
		CuentaBancaria ctaB = this.seleccionar(numero);
		base.remove(ctaB);

	}

}
