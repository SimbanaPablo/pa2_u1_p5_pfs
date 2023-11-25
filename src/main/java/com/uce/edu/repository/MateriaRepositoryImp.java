package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;
@Repository
public class MateriaRepositoryImp implements IMateriaRepository {

	public static List<Materia> base = new ArrayList<Materia>();
	@Override
	public Materia seleccionar(String codigo) {
		System.out.println("Se selecciono el codigo: "+codigo);
		for(Materia ma: base) {
			if(ma.getCodigo().equals(codigo))
				return ma;
			return null;
		}
		return new Materia();
	}

	@Override
	public void insertar(Materia materia) {
		base.add(materia);
		System.out.println("Se inserto: "+materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.borrar(materia.getCodigo());
		this.insertar(materia);
		System.out.println("Se actializo: "+materia);

	}

	@Override
	public void borrar(String codigo) {
		Materia ma = this.seleccionar(codigo);
		base.remove(ma);
		System.out.println("Se elimino: "+codigo);

	}

	@Override
	public List<Materia> seleccionarTodo() {
		return base;
	}

}
