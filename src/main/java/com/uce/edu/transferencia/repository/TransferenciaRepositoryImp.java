package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;
@Repository
public class TransferenciaRepositoryImp implements ITransferenciaRepository {

	public static List<Transferencia> base = new ArrayList<Transferencia>();
	public static Integer numeroTransacciones =0;

	@Override
	public Transferencia seleccionar(String numero) {
		for(Transferencia transf: base) {
			if(transf.getNumero().equals(numero))
				return transf;
			return null;
		}
		return new Transferencia();
	}

	@Override
	public void insertar(Transferencia transf) {
		base.add(transf); 

	}

	@Override
	public void actualizar(Transferencia transf) {
		this.eliminar(transf.getNumero());
		this.insertar(transf);

	}

	@Override
	public void eliminar(String numero) {
		Transferencia transf = this.seleccionar(numero);
		base.remove(transf);

	}

	@Override
	public void insertarTransferencia() {
		numeroTransacciones++;
	}

	@Override
	public Integer seleccionarTodasTransferencias() {
		return numeroTransacciones;
	}

}
