package br.com.hoout.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.hoout.model.dao.VeiculoDao;
import br.com.hoout.model.domain.Veiculo;

public class VeiculoServiceImpl implements VeiculoService {

	@Inject
	private VeiculoDao veiculoDao;
	
	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#getClientes()
	 */
	@Override
	public List<Veiculo> getVeiculos() {
		// TODO Auto-generated method stub
		return veiculoDao.getVeiculos();
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#salvar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoDao.salvar(veiculo);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#atualizar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public void atualizar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		veiculoDao.atualizar(veiculo);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#excluir(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public void excluir(Veiculo veiculo) {
		// TODO Auto-generated method stub
		veiculoDao.excluir(veiculo);
		
	}
	
	

}
















