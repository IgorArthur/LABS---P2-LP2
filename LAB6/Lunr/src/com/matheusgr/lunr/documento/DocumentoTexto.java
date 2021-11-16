package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

/**
 * Documento de texto simples. Não precisa de tratamento complexos nem tem
 * metadados próprios.
 */
class DocumentoTexto extends AbstractDocumento {

	private String tipo = "txt";

	/**
	 * Construtor padrão do documento de texto.
	 * @param id ID do documento.
	 * @param txt Texto do documento.
	 */
	public DocumentoTexto(String id, String txt) {
		this.id = id;
		this.original = txt;
		this.limpo = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, txt).strip();
	}

	/**
	 * Método que cada classe implementa para criar seus metadados.
	 * @return Metadados criados.
	 */
	@Override
	Map<String, String> createMetadados() {
		return new HashMap<String, String>();
	}

	/**
	 * Retorna o tipo do documento a ser extendido pelo AbstractDocumento.
	 * @return Tipo do documento.
	 */
	@Override
	public String getTipo() {
		return this.tipo;
	}

}
