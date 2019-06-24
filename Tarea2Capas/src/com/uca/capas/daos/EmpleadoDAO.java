package com.uca.capas.daos;

import java.util.List;
import com.uca.capas.domain.Empleado;

import org.springframework.dao.DataAccessException;


public interface EmpleadoDAO {
	public List<Empleado> findAll(Integer codigoSuc) throws DataAccessException;
	public Empleado findOne(Integer codigo) throws DataAccessException;
	public int insert(Empleado empleado, Integer newRow) throws DataAccessException;
	public int delete(Integer codigo) throws DataAccessException;
	
}
