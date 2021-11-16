package BibliTex;

/**
 * Logger que extende a interface Looger. Exibe quanto tempo em milisegundos cada metodo demorou para ser executado
 * dentro do sistema.
 */
public class TimeConsoleLogger implements Logger {

    private long tempo = System.currentTimeMillis();

    /**
     * Metodo log padrão que recebe o metodo do TransformaTexto e seu primeiro parametro.
     * @param metodo metodo do TransformaTexto.
     * @param primerPar primeiro parametro do metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo, String primerPar) {

        long timerson = System.currentTimeMillis() - this.tempo;

        String sFinal;
        sFinal = "[" + metodo + " - " + timerson + "ms] " + primerPar + "\n";
        return sFinal;

    }

    /**
     * Metodo log padrão que recebe apenas o metodo do TransformaTexto.
     * @param metodo metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo) {

        long timerson = System.currentTimeMillis() - this.tempo;

        String sFinal;
        sFinal = "[" + metodo + " - " + timerson + "ms]\n";
        return sFinal;

    }
}
