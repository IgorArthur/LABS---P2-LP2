package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.DocumentoDTO;

/**
 * Controller para operações de busca. A busca representa uma entidade básica do
 * sistema mais complexa do que apenas um casamento de padrões de termos de
 * busca.
 * 
 * Quando a busca envolve alguma lógica mais complexa, cabe as entidades de
 * busca realizar tais operações.
 */
public class BuscaController {

	private BuscaService bs;
	private ValidadorBusca bv;

	/**
	 * Construtor padrão do BuscaController.
	 * 
	 * É importante manter um único controllador de busca por sistema.
	 * 
	 * @param bs BuscaService a ser utilizado pelo controller.
	 */
	public BuscaController(BuscaService bs) {
		this.bs = bs;
		this.bv = new ValidadorBusca();
	}


	public DocumentoDTO[] busca(String[] termos) {
		this.bv.valida(termos);
		return this.bs.busca(new BuscaSimples(termos));
	}


	public DocumentoDTO[] busca(Map<String, String> metadados) {
		this.bv.valida(metadados);
		return this.bs.busca(new BuscaAvançada(metadados));
	}


	public String[][] recuperaHistoricoDepuracao(int numero) {
		this.bv.valida(numero);
		return this.bs.recuperaHistorico(numero).debug();
	}


	public String[] recuperaHistoricoIds(int numero) {
		this.bv.valida(numero);
		return this.bs.recuperaHistorico(numero).ids();
	}
	
}
