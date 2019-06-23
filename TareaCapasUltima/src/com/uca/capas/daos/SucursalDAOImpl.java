package com.uca.capas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.domain.Usuario;

@Repository
public class SucursalDAOImpl implements SucursalDAO {
	
	@PersistenceContext(unitName="capas")
	private EntityManager em;

	@Override
	public List<Sucursal> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.sucursal");
		Query query = em.createNativeQuery(sb.toString(), Sucursal.class);
		List<Sucursal> sucursales = query.getResultList();
		return sucursales;
	}
	
	@Override
	public Sucursal findOne(Integer codigo) {
		Sucursal sucursal = em.find(Sucursal.class, codigo);
		return sucursal;
	}

	@Override
	@Transactional
	public int insert(Sucursal sucursal, Integer newRow) throws DataAccessException {
		try {
			if(newRow == 1) em.persist(sucursal);
			else em.merge(sucursal);
			em.flush();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	@Transactional
	public int delete(int codigo) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM public.sucursal WHERE codigo = :c");
		Query query = em.createNativeQuery(sb.toString(), Sucursal.class);
		query.setParameter("c", codigo);
		
		if(query.executeUpdate() != 0) {
			return 1;
		}else {
			return 0;
		}
		
	}

}
