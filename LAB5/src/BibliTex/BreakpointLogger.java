package BibliTex;

/**
 * Logger que extende a interface Looger. Exibe uma mensagem sempre que um método específico, passado como
 * parametro, é executado.
 */
public class BreakpointLogger implements Logger {

    String breaker;

    /**
     * Construtor padrão que recebe o metodo que deverá dar um breakpoint no codigo.
     * @param metodo metodo do TransformaTexto a ser construido o breakpoint.
     */
    public BreakpointLogger(String metodo) {

        this.breaker = metodo;

    }

    /**
     * Metodo log padrão que recebe o metodo do TransformaTexto e seu primeiro parametro.
     * @param metodo metodo do TransformaTexto.
     * @param primerPar primeiro parametro do metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo, String primerPar) {

        if (metodo.equals(breaker)) {
            return "[INVOCADO - " + metodo + " ]\n";
        } else {
            return "";
        }

    }

    /**
     * Metodo log padrão que recebe apenas o metodo do TransformaTexto.
     * @param metodo metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo) {

        if (metodo.equals(breaker)) {
            return "[INVOCADO - " + metodo + " ]\n";
        } else {
            return "";
        }

    }
}
