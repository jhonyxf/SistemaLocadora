package br.com.hoout.model.service;

import java.util.List;

import br.com.hoout.model.domain.Veiculo;

public interface VeiculoService {

	List<Veiculo> getVeiculos();

	Veiculo salvar(Veiculo veiculo);

	void atualizar(Veiculo veiculo);

	void excluir(Veiculo veiculo);

}