package BibliTex;

import java.util.Objects;

/**
 * Classe de transformação que extende a interface AlgoritmoTransformacao. Torna as letras pares do texto original
 * maiusculas, e as impares, minusculas.
 */
public class CaMeLcAsEfY implements AlgoritmoTransformacao {

    private String nome = "CaMeLcAsEfY";

    /**
     * Transforma o texto original. Varia de extensão apra extensão.
     * @param original texto a ser transformado.
     * @return o texto transformado.
     */
    @Override
    public String transforma(String original) {

        String sFinal = "";
        char c;
        String letra = "";
        
        for (int l = 0; l < original.length(); l++) {
            if (l % 2 == 0) {
                c = original.charAt(l);
                letra = c + "";
                sFinal += letra.toUpperCase();
            } else {
                c = original.charAt(l);
                letra = c + "";
                sFinal += letra.toLowerCase();
            }
        }

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
        CaMeLcAsEfY that = (CaMeLcAsEfY) o;
        return Objects.equals(nome, that.nome);
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
