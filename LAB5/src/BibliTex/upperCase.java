package BibliTex;

import java.util.Locale;
import java.util.Objects;

/**
 * Classe de transformação que extende a interface AlgoritmoTransformacao. Transforma todas as letras do texto
 * para maiusculas.
 */
public class upperCase implements AlgoritmoTransformacao{

    private String nome = "upperCase";

    /**
     * Transforma o texto original. Varia de extensão apra extensão.
     * @param original texto a ser transformado.
     * @return o texto transformado.
     */
    @Override
    public String transforma(String original) {

        String sFinal = "";
        sFinal = original.toUpperCase();
        return sFinal;

    }

    /**
     * Retorna o nome da transformação.
     * @return "CaMeLcAsEfY".
     */
    @Override
    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo que compara a Objeto da Classe com outro Objeto. Retorna true caso sejam iguais, false caso não sejam.
     * @param o Objeto a ser comparado.
     * @return true caso sejam iguais, false caso nao sejam.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        upperCase upperCase = (upperCase) o;
        return Objects.equals(nome, upperCase.nome);
    }

    /**
     * Retorna o HashCode do objeto. Neste caso, o Hashcode passa a ser o seu nome.
     * @return o Hashcode do objeto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
