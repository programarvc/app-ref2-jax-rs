package br.com.porto.app.ref.rs;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
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

@Path("/v1/empresa")
@Consumes({ "text/xml", "application/json" })
public class EmpresaResource {
	@Inject
	private HelloService helloService;
	private List<EmpresaDTO> empresas = new ArrayList<EmpresaDTO>(0);

	private ThreadLocal<List<EmpresaDTO>> threadLocal = new ThreadLocal<List<EmpresaDTO>>();

	/**
	 * REtorna uma lista de pojos model recebendo par
	 * 
	 * @param nome
	 * @param skip
	 * @return
	 * 
	 *         filtroNomeEmpresa=tiago&orderBy=codigoEmpresa&orderByDirection=
	 *         ASC&skip=0&top=10
	 * 
	 */
	@GET
	public Response findByNome(
			@QueryParam("filtroNomeEmpresa") final String filtroNomeEmpresa,
			@QueryParam("codigoEmpresa") final Integer codigoEmpresa,
			@QueryParam("orderBy") final String orderBy,
			@QueryParam("orderByDirection") final String orderByDirection,
			@QueryParam("skip") final Integer skip,
			@QueryParam("top") final Integer top) {

		EmpresaDTO pojoModelFilter = new EmpresaDTO();
		pojoModelFilter.setCodigoEmpresa(codigoEmpresa);
		pojoModelFilter.setNomeEmpresa(filtroNomeEmpresa);
		List<EmpresaDTO> empresasSearch = new ArrayList<EmpresaDTO>(0);
		// pojoModel.setNomeEmpresa("Porto Seguro");
		// pojoModel.setCodigoEmpresa(1);
		//
		// EmpresaDTO pojoModelItau = new EmpresaDTO();
		// pojoModel.setNomeEmpresa("Itau");
		// pojoModel.setCodigoEmpresa(2);
		//
		// EmpresaDTO pojoModelAzul = new EmpresaDTO();
		// pojoModel.setNomeEmpresa("Azul Seguros");
		// pojoModel.setCodigoEmpresa(2);
		//
		// pojoModels.add(pojoModel);
		//
		// pojoModels.add(pojoModelItau);

		if (codigoEmpresa == null && filtroNomeEmpresa == null) {
			empresasSearch = helloService.findAll();
		} else {
			pojoModelFilter = helloService.findByCodeAndName(pojoModelFilter);
			empresasSearch.add(pojoModelFilter);
		}

		return Response.status(Response.Status.OK).entity(empresasSearch)
				.build();
	}

	//
	// private EmpresaDTO findByCodeAndName(EmpresaDTO pEmpresaDTO) {
	// EmpresaDTO empresaDTO = null;
	// this.empresas = threadLocal.get();
	//
	// empresaDTO = helloService.findByCodeAndName(pEmpresaDTO);
	//
	// Integer idxOff = null;
	// String nomeEmpresa = pEmpresaDTO.getNomeEmpresa();
	// Integer codigoEmpresa = pEmpresaDTO.getCodigoEmpresa();
	// if (codigoEmpresa != null
	// && (nomeEmpresa == null || nomeEmpresa.length() == 0)) {
	// idxOff = this.empresas.indexOf(pEmpresaDTO);
	// } else {
	// EmpresaComparator empComparator = new EmpresaComparator();
	// // Collections.sort(empresas, empComparator);
	// idxOff = Collections.binarySearch(empresas, pEmpresaDTO,
	// empComparator);
	// }
	//
	// if (idxOff >= 0) {
	// empresaDTO = this.empresas.get(idxOff);
	// }
	// return empresaDTO;
	// }

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
	public EmpresaDTO find(@PathParam("id") final Integer primaryKey) {
		EmpresaDTO pojoModel = new EmpresaDTO();
		pojoModel.setCodigoEmpresa(primaryKey);
		pojoModel = helloService.findByCodeAndName(pojoModel);
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
	public Response create(EmpresaDTO pojoModel) throws URISyntaxException {

		empresas.add(pojoModel);

		threadLocal.set(empresas);

		empresas = helloService.create(pojoModel);

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
	public Response delete(@PathParam("id") Integer primaryKey) {
		EmpresaDTO empresaChanged = new EmpresaDTO();
		empresaChanged.setCodigoEmpresa(primaryKey);
		this.empresas = threadLocal.get();
		this.empresas.remove(this.empresas.indexOf(empresaChanged));

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
	public Response update(@PathParam("id") final Integer primaryKey,
			final EmpresaDTO pojoModel) {

		EmpresaDTO empresaChanged = new EmpresaDTO();
		empresaChanged.setCodigoEmpresa(primaryKey);
		empresaChanged.setNomeEmpresa(pojoModel.getNomeEmpresa());

		helloService.update(empresaChanged);

		return Response.status(Response.Status.OK).entity(empresaChanged)
				.build();
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
	public EmpresaDTO getHelloWorldJSONDto() {
		EmpresaDTO ob = new EmpresaDTO();
		ob.setNomeEmpresa("tiago lopes");
		ob.setCodigoEmpresa(98);

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
