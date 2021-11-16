package com.matheusgr.lunr.busca;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;
import java.util.Map;

/**
 * Busca representa uma método para buscar informações em documentos. É extensível.
 */
public interface Busca {

    /**
     * Realiza a busca a partir da consulta ao DocumentoService.
     *
     * @param ds DocumentoService a ser utilizado para busca.
     * @return Mapa com os documentos encontrados
     */
    public Map<Documento, Integer> busca(DocumentoService ds);

    /**
     * Descreve uma consulta para explicar a consulta que foi feita.
     *
     * @return Descrição da busca, onde cada linha representa um parâmetro de busca
     *         e as colunas representam um detelhamento de cada parâmetro.
     */
    public String[][] descreveConsulta();

}
