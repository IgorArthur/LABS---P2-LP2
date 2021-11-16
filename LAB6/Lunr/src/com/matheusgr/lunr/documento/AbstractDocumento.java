package com.matheusgr.lunr.documento;

import biblitex.TransformaTexto;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * AbstractDocumento é uma extensão da Interface do Documentos que busca reunir comportamentos em comum dos tipos de
 * documento já existentes.
 */
abstract class AbstractDocumento implements Documento{

    protected String id;
    protected String original;
    protected String limpo;
    protected Map<String, String> metadados;
    protected String[] split;

    /**
     * Retorna a quantidade de texto útil, sendo definido como a quantidade de
     * caracteres úteis (sem caracteres estranhos e sem espaços) sobre o total de
     * caracteres original (incluindo espaços).
     *
     * @return Percentual de texto útil (entre 0 e 1, inclusives).
     */
    @Override
    public double metricaTextoUtil() {
        long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo).length();
        return (1.0 * extractedSize) / this.original.length();
    }

    /**
     * Retorna a identificação do documento. A documentação é definida pelo próprio
     * documento e é uma String sem formatação específica. Todo documento gerado
     * pelo Lunr começa com o símbolo "_". O identificador não pode ser vazio ou
     * nulo.
     *
     * @return Identificação do documento.
     * @throws NullPointerException Caso o ID seja nulo.
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * Retorna os termos do texto em formato de String. Não podem existir termos
     * vazios (só de espaços, tabulações ou string vazia).
     *
     * @return Array de termos extraídos do documento.
     */
    @Override
    public String[] getTexto() {
        if (this.split == null) {
            this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
                    .split(" ");
            Arrays.sort(this.split);
        }
        return this.split;
    }

    /**
     * Método que cada classe implementa para criar seus metadados.
     * @return Metadados criados.
     */
    abstract Map<String, String> createMetadados();

    /**
     * Retorna o tipo do documento a ser extendido pelo AbstractDocumento.
     * @return Tipo do documento.
     */
    abstract String getTipo();

    /**
     * Retorna metadados referente ao documento. Detalhes como seu tipo, autor, ou
     * características próprias do documento.
     *
     * Idealmente, todo metadado terá como características:
     *
     * LINHAS, TAMANHO (número de caracteres), METADATADATE (hora atual do sistema
     * na criação dos metadados, em ms), TIPO.
     *
     * @return Mapa com os metadados descrito em forma textual.
     */
    @Override
    public Map<String, String> getMetadados() {
        if (this.metadados != null) {
            return this.metadados;
        }
        this.metadados = this.createMetadados();
        this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
        this.metadados.put("TAMANHO", "" + this.limpo.length());
        this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
        this.metadados.put("TIPO", "" + getTipo());
        return this.metadados;
    }

    /**
     * Retorna o objeto formatado para String, afim de obter uma melhor vizualiação do mesmo.
     * @return Objeto em String.
     */
    @Override
    public String toString() {
        return "===" + this.id + System.lineSeparator() + this.limpo;
    }

    /**
     * Compara se o objeto é igual a outro objeto passado como parâmetro.
     * @param o Objeto a ser comparado.
     * @return true, se forem iguais. false, se não forem.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDocumento that = (AbstractDocumento) o;
        return Objects.equals(id, that.id) && Objects.equals(original, that.original) && Objects.equals(limpo, that.limpo) && Objects.equals(metadados, that.metadados) && Arrays.equals(split, that.split);
    }

    /**
     * Gera um HashCode padão para o objeto.
     * @return HashCode gerado.
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(id, original, limpo, metadados);
        result = 31 * result + Arrays.hashCode(split);
        return result;
    }
}
