package BibliTex;

/**
 * Interface dos Loggers.
 */
public interface Logger {

    /**
     * Metodo log padrão que recebe o metodo do TransformaTexto e seu primeiro parametro.
     * @param metodo metodo do TransformaTexto.
     * @param primerPar primeiro parametro do metodo do TransformaTexto.
     */
    public String log(String metodo, String primerPar);

    /**
     * Metodo log padrão que recebe apenas o metodo do TransformaTexto.
     * @param metodo metodo do TransformaTexto.
     */
    public String log(String metodo);

}
