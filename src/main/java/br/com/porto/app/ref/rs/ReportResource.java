package br.com.porto.app.ref.rs;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.porto.app.ref.report.GenerateReportsXls;

/**
 * A simple REST service which is able to say hello to someone using
 * HelloService Please take a look at the web.xml where JAX-RS is enabled
 * 
 */

@Path("/v1/report")
@Consumes({ "text/xml", "application/json" })
public class ReportResource {
	@Inject
	private GenerateReportsXls reportService;

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
	@Path("/dashboards")
	@Produces({ "application/json" })
	public List<Object[]> findDashboards() {
		List<Object[]> dadosDashboard = null;
		try {
			dadosDashboard = reportService.readDataXls();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return dadosDashboard;
	}
}
