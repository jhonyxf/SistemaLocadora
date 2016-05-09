package br.com.hoout.model.service;

import java.util.List;

import br.com.hoout.model.domain.Cliente;

public interface ClienteService {

	List<Cliente> getClientes();

	Cliente salvar(Cliente cliente);

	void atualizar(Cliente cliente);

	void excluir(Cliente cliente);

}