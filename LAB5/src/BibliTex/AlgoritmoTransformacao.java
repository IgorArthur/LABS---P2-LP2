package BibliTex;

/**
 * Interface dos algoritmos de trasnformação de texto.
 */
public interface AlgoritmoTransformacao {

    /**
     * Transforma o texto original. Varia de extensão apra extensão.
     * @param original texto a ser transformado.
     * @return o texto transformado.
     */
    public String transforma(String original);

    /**
     * Retorna o nome da transformação.
     * @return o nome da transformação.
     */
    public String getNome();

}

