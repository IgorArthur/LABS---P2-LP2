package BibliTex;

import java.util.*;

/**
 * Classe que transforma os textos do sistema, além de guardar, cadastrar e contar as transformações do sistema.
 * Tambem guarda um historico dos textos originais e uma lista dos algoritmos cadastrados. Começa com 5 algoritmos
 * padrão cadastrados (CaMeLcAsEfY, clean, cleanSpaces, InterrogaPraPontos, upperCase). Também pode receber um
 * Logger do sistema.
 */
public class TransformaTexto {

    private Map<String, AlgoritmoTransformacao> transformacoes = new HashMap<>();
    private List<String> historico = new ArrayList<>();
    private Set<String> originais = new HashSet<>();
    private Logger log;

    /**
     * Construtor padrão  que nao recebe Logger. Cadastra automaticamente os 5 algoritmos padrão (CaMeLcAsEfY, clean,
     * cleanSpaces, InterrogaPraPontos, upperCase)
     */
    public TransformaTexto() {

        this.transformacoes.put("CaMeLcAsEfY", new CaMeLcAsEfY());
        this.transformacoes.put("clean", new clean());
        this.transformacoes.put("cleanSpaces", new cleanSpaces());
        this.transformacoes.put("InterrogaPraPontos", new InterrogaPraPontos());
        this.transformacoes.put("upperCase", new upperCase());

    }

    /**
     * Construtor padrão  que nao recebe Logger. Cadastra automaticamente os 5 algoritmos padrão (CaMeLcAsEfY,
     * clean, cleanSpaces, InterrogaPraPontos, upperCase)
     * @param log Logger que irá designar alguma função no codigo.
     */
    public TransformaTexto(Logger log) {

        this.transformacoes.put("CaMeLcAsEfY", new CaMeLcAsEfY());
        this.transformacoes.put("clean", new clean());
        this.transformacoes.put("cleanSpaces", new cleanSpaces());
        this.transformacoes.put("InterrogaPraPontos", new InterrogaPraPontos());
        this.transformacoes.put("upperCase", new upperCase());
        this.log = log;

    }

    /**
     * Cadastra uma tranformacao, extendida da interface AlgoritmoTransformacao. Lança uma exceção caso nao seja
     * informado um nome de algoritmo ou um algoritmo.
     * @param nomeAlgoritmo nome que o algoritmo sera cadastrado.
     * @param algoritmo algoritmo que sera cadastrado.
     */
    public void cadastraTransformacao(String nomeAlgoritmo, AlgoritmoTransformacao algoritmo) throws Exception {

        if (this.log != null) {
            System.out.print(this.log.log("cadastraTransformacao", nomeAlgoritmo));
        } if (nomeAlgoritmo.equals(null) || algoritmo == null) {
            throw new Exception("ENTRADA INVÁLIDA!");
        }
        this.transformacoes.put(nomeAlgoritmo, algoritmo);

    }

    /**
     * Transforma um texto original, utilizando alguma transformacao cadastrada. Lança uma exceção caso nao seja
     * informado um tipo de transformacao ou um texto original.
     * @param tipoTransforma nome da transformacao que sera usada.
     * @param original texto a ser transformado.
     * @return o texto transformado.
     */
    public String transforma(String tipoTransforma, String original) throws Exception {

        if (this.log != null) {
            System.out.print(this.log.log("transforma", tipoTransforma));
        } if (tipoTransforma.equals(null) || original == null) {
            throw new Exception("ENTRADA INVÁLIDA!");
        } if (transformacoes.containsKey(tipoTransforma)) {
            String retorno = transformacoes.get(tipoTransforma).transforma(original);
            String hist = original + " -> " + tipoTransforma + " -> " + retorno;
            historico.add(hist);
            originais.add(original);
            return retorno;
        } else {
            return("TRANSFORMAÇÃO INVÁLIDA!");
        }
    }

    /**
     * Conta quantas tranformacoes foram feitas pelo sistema.
     * @return a quantidade de transformacoes feitas pelo sistema ate o momento.
     */
    public int contaTransformacao() {

        if (this.log != null) {
            System.out.print(this.log.log("contaTransformacao"));
        }
        return historico.size();

    }

    /**
     * Retorna a transformacao de numero informado. A contagem começa do 0. Lança uma exceção nao caso seja
     * informado um numero.
     * @param numeroTransformacao numero da transformacao a ser exibida.
     * @return o texto original + o tipo de transformacao + o texto transformado.
     */
    public String historico(int numeroTransformacao) throws Exception {

        String numeroS = numeroTransformacao + "";
        if (numeroS.equals(null)) {
            throw new Exception("ENTRADA INVÁLIDA!");
        }
        if (this.log != null) {
            System.out.print(this.log.log("historico", numeroS));
        }
        return historico.get(numeroTransformacao);

    }

    /**
     * Lista os textos orignais. Os textos não se repetem (são unicos) e são case-sensitive.
     * @return os textos originais.
     */
    public String listarOriginais() {

        if (this.log != null) {
            System.out.print(this.log.log("listarOriginais"));
        }
        String retorno = "";
        for (String original : originais) {
            retorno += original + "\n";
        }
        return retorno;

    }

    /**
     * Lista os algoritmos de transformacao em ordem alfabetica.
     * @return
     */
    public String listarTransformacoes() {

        if (this.log != null) {
            System.out.print(this.log.log("listarTransformacoes"));
        }
        String retorno = "";
        List<String> trans = new ArrayList<>();
        for (String nome : this.transformacoes.keySet()) {
            trans.add(this.transformacoes.get(nome).getNome());
        }

        Collections.sort(trans);

        for (int c = 0; c < trans.size(); c++) {
            retorno += trans.get(c) + "\n";
        }
        return retorno;

    }

}
