package br.com.hoout.model.dao;

import java.util.List;

import br.com.hoout.model.domain.Cliente;

public interface ClienteDao {

	List<Cliente> getClientes();

	Cliente salvar(Cliente cliente);

	void excluir(Cliente cliente);

	void atualizar(Cliente cliente);

}