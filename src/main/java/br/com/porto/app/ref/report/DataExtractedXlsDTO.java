package br.com.porto.app.ref.report;

import java.util.List;

public class DataExtractedXlsDTO {

	// ['Dias', '01/05/2004', '01/05/2004', '01/05/2004', '01/05/2004',
	// '01/05/2004', '01/05/2004'],
	// ['Orçamento com sucesso', 165, 938, 522, 998, 450, 914.6],
	// ['Orçamento com falhas', 135, 1120, 599, 1268, 288, 682.54],
	// ['Transmissões com sucesso', 157, 1167, 587, 807, 397, 623.67],
	// ['Transmissões com falhas', 139, 1110, 615, 968, 215, 609.4],
	// ['% de conversao', 90, 691, 629, 1026, 366, 569.6]

	private String data;
	private String valor;
	private String nameGraph;
	private String nameSeries;
	private String percentualConversao;
	private List<Object[]> dados;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return the nameGraph
	 */
	public String getNameGraph() {
		return nameGraph;
	}

	/**
	 * @param nameGraph
	 *            the nameGraph to set
	 */
	public void setNameGraph(String nameGraph) {
		this.nameGraph = nameGraph;
	}

	/**
	 * @return the nameSeries
	 */
	public String getNameSeries() {
		return nameSeries;
	}

	/**
	 * @param nameSeries
	 *            the nameSeries to set
	 */
	public void setNameSeries(String nameSeries) {
		this.nameSeries = nameSeries;
	}

	/**
	 * @return the percentualConversao
	 */
	public String getPercentualConversao() {
		return percentualConversao;
	}

	/**
	 * @param percentualConversao
	 *            the percentualConversao to set
	 */
	public void setPercentualConversao(String percentualConversao) {
		this.percentualConversao = percentualConversao;
	}

	/**
	 * @return the dados
	 */
	public List<Object[]> getDados() {
		return dados;
	}

	/**
	 * @param dados
	 *            the dados to set
	 */
	public void setDados(List<Object[]> dados) {
		this.dados = dados;
	}

}
