package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvançada realiza uma operação de busca a partir de metadados.
 *
 * Dado os metadados, deve se buscar por tais documentos e retornar aqueles que possuírem em sua composição todos
 * os metadados passados como parâmetro.
 *
 * Os documentos que não tem nenhum dos termos pesquisados, não devem ser
 * retornados.
 */
class BuscaAvançada implements Busca {

    private Map<String, String> metadados;

    /**
     * Construtor padrão com os termos a serem encontrados.
     *
     * Os termos não vazios são ignorados. Pelo menos 1 termo deve ser não vazio.
     *
     * @param metadados Metadados a serem pesquisados.
     */
    public BuscaAvançada(Map<String, String> metadados) {
        (new ValidadorBusca()).valida(metadados);
        this.metadados = metadados;
    }

    /**
     * Realiza a busca a partir da consulta ao DocumentoService.
     *
     * Apenas serão retornados Documentos que possuírem todos os metadados buscados.
     *
     * @param ds DocumentoService a ser utilizado para busca.
     * @return Mapa com os documentos encontrados.
     */
    public Map<Documento, Integer> busca(DocumentoService ds) {
        Map<Documento, Integer> respostaDocumento = new HashMap<>();
        for (String metaKey : this.metadados.keySet()) {
            if (metaKey.isBlank()) {
                continue;
            }
            for (Documento d : ds.busca(metadados)) {
                respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
            }
        }
        return respostaDocumento;
    }

    /**
     * Descreve uma consulta para explicar a consulta que foi feita.
     *
     * @return Descrição da busca, onde cada linha representa um parâmetro de busca
     *         e as colunas representam um detelhamento de cada parâmetro.
     */
    public String[][] descreveConsulta() {
        String[][] resultado = new String[this.metadados.size()][];
        int count  = 0;
        for (String meta: this.metadados.keySet()) {
            resultado[count] = new String[] {"TERMO " + (count + 1), meta};
            count++;
        }
        return resultado;
    }

}
