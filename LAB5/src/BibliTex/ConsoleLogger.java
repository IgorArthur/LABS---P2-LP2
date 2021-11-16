package BibliTex;

/**
 * Logger que extende a interface Looger. Exibe antes de cada metodo invocado, o metodo invocado e seu primeiro
 * parametro.
 */
public class ConsoleLogger implements Logger {

    /**
     * Metodo log padrão que recebe o metodo do TransformaTexto e seu primeiro parametro.
     * @param metodo metodo do TransformaTexto.
     * @param primerPar primeiro parametro do metodo do TransformaTexto.
     */
    public String log(String metodo, String primerPar) {

        String sFinal;
        sFinal = "[" + metodo + "] " + primerPar + "\n";
        return sFinal;

    }

    /**
     * Metodo log padrão que recebe apenas o metodo do TransformaTexto.
     * @param metodo metodo do TransformaTexto.
     */
    public String log(String metodo) {

        String sFinal;
        sFinal = "[" + metodo + "]\n";
        return sFinal;

    }
}
