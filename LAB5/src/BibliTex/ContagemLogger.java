package BibliTex;

import java.util.*;

/**
 * Logger que extende a interface Looger. Exibe em seu toString quantas vezes cada metodo foi chamado.
 */
public class ContagemLogger implements Logger {

    private Map<String, Integer> contagem = new HashMap<>();

    /**
     * Metodo log padrão que recebe o metodo do TransformaTexto e seu primeiro parametro.
     * @param metodo metodo do TransformaTexto.
     * @param primerPar primeiro parametro do metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo, String primerPar) {
        if (contagem.containsKey(metodo) == false) {
            this.contagem.put(metodo, 1);
        } else {
            int value = this.contagem.get(metodo);
            value++;
            this.contagem.put(metodo, value);
        }
        return "";
    }

    /**
     * Metodo log padrão que recebe apenas o metodo do TransformaTexto.
     * @param metodo metodo do TransformaTexto.
     */
    @Override
    public String log(String metodo) {
        if (contagem.containsKey(metodo) == false) {
            this.contagem.put(metodo, 1);
        } else {
            int value = this.contagem.get(metodo);
            value++;
        }
        return "";
    }

    /**
     * Retorna quantas vezes cada metodo foi chamado.
     * @return quantas vezes cada metodo foi chamado.
     */
    @Override
    public String toString() {
        String retorno = "";
        for (String metodo : this.contagem.keySet()) {
            retorno += metodo + " - " + contagem.get(metodo) + "\n";
        }
        return retorno;

    }

}
