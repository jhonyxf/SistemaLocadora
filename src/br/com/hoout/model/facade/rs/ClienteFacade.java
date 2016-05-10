package br.com.hoout.model.facade.rs;


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

import br.com.hoout.model.domain.Cliente;
import br.com.hoout.model.service.ClienteService;

@Path("/cliente")
@Produces(
			{MediaType.APPLICATION_JSON,
			MediaType.APPLICATION_XML}
		)
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ClienteFacade {
	
	@Inject
	ClienteService clienteService;

	@GET
	public List<Cliente> getClientes() {
		return clienteService.getClientes();
	}
	
	@POST
	public Cliente salvar(Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@PUT
	public void atualizar(Cliente cliente) {
		clienteService.atualizar(cliente);
	}

	@DELETE
	@Path("/{codigoCliente}")
	public void excluir(@PathParam("codigoCliente") Integer codigoCliente) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(codigoCliente);
		clienteService.excluir(cliente);
	}

}
















