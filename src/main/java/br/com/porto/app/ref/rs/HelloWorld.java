package br.com.porto.app.ref.rs;

import java.net.URISyntaxException;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * A simple REST service which is able to say hello to someone using
 * HelloService Please take a look at the web.xml where JAX-RS is enabled
 * 
 */

@Path("/hello")
@Consumes({ "text/xml", "application/json" })
public class HelloWorld {
	@Inject
	HelloService helloService;

	/**
	 * REtorna uma lista de pojos model recebendo par
	 * 
	 * @param nome
	 * @param skip
	 * @return
	 */
	@GET
	public Response findByNome(@QueryParam("nome") final String nome,
			@QueryParam("skip") final Integer skip) {

		List<PojoModelDTO> pojoModels = new ArrayList<PojoModelDTO>();
		PojoModelDTO pojoModel = new PojoModelDTO();
		pojoModel.setNome("Eça de Queiroz");
		pojoModel.setIdade(29);

		pojoModels.add(pojoModel);

		return Response.status(Response.Status.OK).entity(pojoModels).build();
	}

	/**
	 * Procura um pojo model pela chave primaria.
	 * 
	 * @param primaryKey
	 *            chave primaria
	 * @return pojo model
	 */
	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public PojoModelDTO find(@PathParam("id") final String primaryKey) {
		PojoModelDTO pojoModel = new PojoModelDTO();
		pojoModel.setNome("Eça de Queiroz");
		pojoModel.setIdade(29);
		return pojoModel;
	}

	/**
	 * Cria / Insere um novo pojo model.
	 * 
	 * @param pojoModel
	 *            pojo model
	 * 
	 * @return pojo model
	 * 
	 * @throws URISyntaxException
	 *             erros relacionados ao build do pojo model
	 */
	@POST
	public Response create(PojoModelDTO pojoModel) throws URISyntaxException {

		return Response.status(Response.Status.CREATED).entity(pojoModel)
				.build();
	}

	/**
	 * Remove um pojo model.
	 *
	 * @param primaryKey
	 *            chave primaria
	 * 
	 * @return status OK
	 */
	@DELETE
	@Path("{id}")
	@Produces({ "text/xml", "application/json" })
	@Consumes({ "text/xml", "application/json" })
	public Response delete(@PathParam("id") String primaryKey) {

		return Response.status(Response.Status.NO_CONTENT).build();
	}

	/**
	 * Atualiza um pojo model.
	 *
	 * @param primaryKey
	 *            chave primaria
	 * 
	 * @param pojoModel
	 *            Pojo model para atualização
	 * 
	 * @return sucesso e o pojo model alterado
	 */
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") final String primaryKey,
			final PojoModelDTO pojoModel) {

		return Response.status(Response.Status.OK).entity(pojoModel).build();
	}

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getHelloWorldJSON() {
		return "{\"result\":\"" + helloService.createHelloMessage("World")
				+ "\"}";
	}

	@GET
	@Path("/json/dto")
	@Produces({ "application/json" })
	public PojoModelDTO getHelloWorldJSONDto() {
		PojoModelDTO ob = new PojoModelDTO();
		ob.setNome("tiago lopes");
		ob.setIdade(98);

		return ob;
	}

	@GET
	@Path("/atendimento")
	@Produces({ "application/json" })
	public List<PojoModelDTO> getHelloWorldJSONDtos() {
		PojoModelDTO ob = new PojoModelDTO();
		List<PojoModelDTO> lst = new ArrayList<PojoModelDTO>();
		ob.setNome("tiago lopes");
		ob.setIdade(98);
		lst.add(ob);

		return lst;
	}

	@GET
	@Path("/xml")
	@Produces({ "application/xml" })
	public String getHelloWorldXML() {
		return "<xml><result>" + helloService.createHelloMessage("World")
				+ "</result></xml>";
	}

}
