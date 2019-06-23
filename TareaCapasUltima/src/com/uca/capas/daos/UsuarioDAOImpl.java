package com.uca.capas.daos;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager em;
	
	@Override
	public int findUser(Usuario user) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.usuario where usuario = :u and clave =:c");
		Query query = em.createNativeQuery(sb.toString(), Usuario.class);
		query.setParameter("u", user.getUsuario());
		query.setParameter("c", user.getClave());
		if(query.getResultList().isEmpty() == false) {
			return 1;
		}else {
			return 0;
		}
	}

}
