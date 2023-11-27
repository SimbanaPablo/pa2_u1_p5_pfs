package com.uce.edu.transferencia.repository;

import com.uce.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	public Transferencia seleccionar(String numero);
	public void insertar(Transferencia transf);
	public void actualizar(Transferencia transf);
	public void eliminar(String numero);
	public void insertarTransferencia();
	public Integer seleccionarTodasTransferencias();
	
}
