package br.com.hoout.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hoout.model.domain.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	
	@PersistenceContext(unitName="SISTEMALOCADORAPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientes() {
		Query query = entityManager.createQuery("from Cliente");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#salvar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#excluir(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public void excluir(Cliente cliente) {
		Cliente clienteMerge = entityManager.merge(cliente);
		entityManager.remove(clienteMerge);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#atualizar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public void atualizar(Cliente cliente) {
		Cliente clienteMerge = entityManager.merge(cliente);
		entityManager.persist(clienteMerge);
		
	}

}
