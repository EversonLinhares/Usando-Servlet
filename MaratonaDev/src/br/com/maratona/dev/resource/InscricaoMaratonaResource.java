package br.com.maratona.dev.resource;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path(value = "/inscricao")
public class InscricaoMaratonaResource {
	
	
    List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
    public void init() {
		pessoas.add(new Pessoa("Kleber",1));
		pessoas.add(new Pessoa("Marcos",2));
		pessoas.add(new Pessoa("Stag",3));
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("lista/inscritos")
	public List<Pessoa> matricula() {
		init();
		return pessoas;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("find/inscrito/{id}")
	public Pessoa matriculaPorId(@PathParam("id")String id) {
		init();
		for(Pessoa indice : pessoas) {
			if(indice.getMatricula().equals(new Integer(id))) {
				return indice;
			}
		}
		return new Pessoa();
	}
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("incluir/inscrito")
	public Response incluir (Pessoa pessoa) {
		init();
		pessoa.setMatricula(pessoas.size()+1);
		pessoas.add(pessoa);
		return Response.status(Status.CREATED).entity(pessoa).build();
		
	}
	

	
	


}
