package com.matheusgr.lunr.busca;

/**
 * Armazena o histórico de uma busca realizada. O histórico não deve ter custo
 * computacional e deve ser genérico para diferentes tipos de busca.
 */
public class HistoricoBusca {

	private BuscaSimples buscaSimples;
	private BuscaAvançada buscaAvançada;
	private String[] documentosIds;

	/**
	 * Construção do histórico a partir dos parâmetros dos termos passados pela BuscaSimples.
	 * 
	 * @param buscaSimples  Objeto de busca realizado.
	 * @param documentosIds Resultado da pesquisa.
	 */
	public HistoricoBusca(BuscaSimples buscaSimples, String[] documentosIds) {
		this.buscaSimples = buscaSimples;
		this.documentosIds = documentosIds;
	}

	/**
	 * Construção do histórico a partir dos metadados dos termos passados pela BuscaAvançada.
	 *
	 * @param buscaAvançada Objeto de busca realizado.
	 * @param documentosIds Resultado da pesquisa.
	 */
	public HistoricoBusca(BuscaAvançada buscaAvançada, String[] documentosIds) {
		this.buscaAvançada = buscaAvançada;
		this.documentosIds = documentosIds;
	}

	/**
	 * Depura uma busca onde cada linha representa um parâmetro de busca e cada
	 * coluna representa esse parâmetro em detalhes.
	 * 
	 * @return Depuração da busca. Cada linha representa um parâmetro de busca e
	 *         cada coluna um detalhamento desse parâmetro (ex.: NOME_DO_PARAMETRO e
	 *         VALOR).
	 */
	public String[][] debug() {
		return this.buscaSimples.descreveConsulta();
	}


	/**
	 * Retorna os IDs dos documentos retornados da busca.
	 * 
	 * @return Array de string com IDs dos documentos retornados.
	 */
	public String[] ids() {
		return documentosIds;
	}

}