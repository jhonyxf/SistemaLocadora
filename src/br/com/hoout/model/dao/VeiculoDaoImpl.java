package br.com.hoout.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.hoout.model.domain.Veiculo;

public class VeiculoDaoImpl implements VeiculoDao {

	
	@PersistenceContext(unitName="SISTEMALOCADORAPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Veiculo> getVeiculos() {
		Query query = entityManager.createQuery("from Veiculo");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#salvar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public Veiculo salvar(Veiculo veiculo) {
		entityManager.persist(veiculo);
		return veiculo;
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#excluir(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public void excluir(Veiculo veiculo) {
		Veiculo veiculoMerge = entityManager.merge(veiculo);
		entityManager.remove(veiculoMerge);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.dao.ClienteDao#atualizar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	public void atualizar(Veiculo veiculo) {
		Veiculo veiculoMerge = entityManager.merge(veiculo);
		entityManager.persist(veiculoMerge);
		
	}

}
