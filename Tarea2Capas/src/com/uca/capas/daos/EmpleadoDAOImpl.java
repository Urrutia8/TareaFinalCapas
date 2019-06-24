package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;

@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public List<Empleado> findAll(Integer codigoSuc) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.empleado where id_sucursal = :cs");
		Query query = em.createNativeQuery(sb.toString(), Empleado.class);
		query.setParameter("cs", codigoSuc);
		List<Empleado> resultSet = query.getResultList();
		return resultSet;		
	}

	@Override
	public Empleado findOne(Integer codigo) throws DataAccessException {
		Empleado empleado = em.find(Empleado.class, codigo);
		return empleado;
	}

	@Override
	@Transactional
	public int insert(Empleado empleado, Integer newRow) throws DataAccessException {
		try {
			if(newRow == 1) em.persist(empleado);
			else em.merge(empleado);
			em.flush();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int delete(Integer codigo) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM public.empleado WHERE codigo = :c");
		Query query = em.createNativeQuery(sb.toString(), Sucursal.class);
		query.setParameter("c", codigo);
		
		if(query.executeUpdate() != 0) {
			return 1;
		}else {
			return 0;
		}
	}

}
