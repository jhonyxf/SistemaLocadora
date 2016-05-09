package br.com.hoout.model.dao;

import java.util.List;

import br.com.hoout.model.domain.Veiculo;

public interface VeiculoDao {

	List<Veiculo> getVeiculos();

	Veiculo salvar(Veiculo veiculo);

	void excluir(Veiculo veiculo);

	void atualizar(Veiculo veiculo);

}