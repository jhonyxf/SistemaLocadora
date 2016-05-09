package br.com.hoout.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.hoout.model.dao.ClienteDao;
import br.com.hoout.model.domain.Cliente;

public class ClienteServiceImpl implements ClienteService {

	@Inject
	private ClienteDao clienteDao;
	
	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#getClientes()
	 */
	@Override
	public List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return clienteDao.getClientes();
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#salvar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.salvar(cliente);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#atualizar(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.atualizar(cliente);
	}

	/* (non-Javadoc)
	 * @see br.com.hoout.model.service.ClienteService#excluir(br.com.hoout.model.domain.Cliente)
	 */
	@Override
	@Transactional
	public void excluir(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteDao.excluir(cliente);
		
	}
	
	

}
















