package br.com.hoout.model.facade.rs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.hoout.model.domain.Veiculo;
import br.com.hoout.model.service.VeiculoService;

@Path("/veiculo")
@Produces(
			{MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML}
		)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoFacade {
	
	@Inject
	VeiculoService veiculoService;

	@GET
	public List<Veiculo> getVeiculos() {
		return veiculoService.getVeiculos();
	}
	
	@POST
	public Veiculo salvar(Veiculo veiculo) {
		return veiculoService.salvar(veiculo);
	}

	@PUT
	public void atualizar(Veiculo veiculo) {
		veiculoService.atualizar(veiculo);
	}

	@DELETE
	@Path("/{codigoVeiculo}")
	public void excluir(@PathParam("codigoVeiculo") Integer codigoVeiculo) {
		Veiculo veiculo = new Veiculo();
		veiculo.setCodigo(codigoVeiculo);
		veiculoService.excluir(veiculo);
	}

}
















