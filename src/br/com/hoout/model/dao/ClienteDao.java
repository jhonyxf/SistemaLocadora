package br.com.hoout.model.dao;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import br.com.hoout.model.domain.Cliente;

public interface ClienteDao {

	List<Cliente> getClientes();

	@ValidateOnExecution
	Cliente salvar(@Valid Cliente cliente);

	void excluir(Cliente cliente);

	void atualizar(Cliente cliente);

}