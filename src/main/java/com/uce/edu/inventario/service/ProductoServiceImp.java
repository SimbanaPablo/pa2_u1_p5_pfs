package com.uce.edu.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Producto;
@Service
public class ProductoServiceImp implements IProductoService {
	@Autowired
	private IProductoRepository iProductoRepository;

	@Override
	public Producto buscar(String codigoBarras) {
		return this.iProductoRepository.seleccionar(codigoBarras);
	}

	@Override
	public void guardar(Producto pro) {
		this.iProductoRepository.insertar(pro);

	}

	@Override
	public void actualizar(Producto pro) {
		this.iProductoRepository.actualizar(pro);

	}

	@Override
	public void eliminar(String codigoBarras) {
		this.iProductoRepository.eliminar(codigoBarras);

	}

}
