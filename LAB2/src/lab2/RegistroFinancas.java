package lab2;

import java.util.ArrayList;

/**
* A classe RegistroFinancas permite realizar operações (depósito e saque) do dinheiro, além de permitir a organização dos ganhos em um Array. A classe também possibilita detalhar informações sobre os gastos e imprimir as últimas 5 informações informadas.
* 
* @author Igor Arthur Ferreira Ramos
*/
public class RegistroFinancas {

    private int total;
    private int inicial;
    private int tamanho;
    private int despesas;
    private int[] ganhos;
    
    private String listaGanhos = "";
    private String retorno;
    private String retornoDetalhes = "";

    private ArrayList<String>detalhesList = new ArrayList<String>();

    /** 
     * Constrói um novo registro, com n ganhos a serem contabilizados.
     * @param ganhosIniciais o valor inicial que o aluno possui 
     * @param totalDeGanhos Tamanho do Array que contabiliza os ganhos.
     */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {

        inicial = ganhosIniciais;
        tamanho = totalDeGanhos;
        ganhos = new int[tamanho];

    }

    /** 
     * Adiciona um valor no Array de tamanho n 
     * @param valorCentavos valor em centavos que será contabilizado.
     * @param posicaoGanho posição que o valor vai ocupar no Array.
     * Uma posição, depois de ocupada, pode ser sobrescrita.
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {

        ganhos[posicaoGanho - 1] = valorCentavos;

    }

    /** 
     * Paga uma despesa.
     * @param valorCentavos valor da despeza a ser paga.
     */
    public void pagaDespesa(int valorCentavos) {

        despesas += valorCentavos;

    }

    /**
     * Paga uma despesa e informa os detalhes da mesma.
     * @param valorCentavos valor da despeza a ser paga.
     * @param detalhes detalhe da despeza a ser paga.
     */
    public void pagaDespesa(int valorCentavos, String detalhes) {

        despesas += valorCentavos;
        detalhesList.add(detalhes);

    }

    /**
     * Lista os últimos 5 detalhes registrados no sistema.
     * @return
     */
    public String listarDetalhes() {

        for (int c = detalhesList.size() - 5; c < detalhesList.size(); c++) {
            if (c == detalhesList.size() - 5) {
                retornoDetalhes += "5 últimos gastos: " + detalhesList.get(c);
            } else {
                retornoDetalhes += "\n" + detalhesList.get(c);
            }
        }

        return retornoDetalhes;
    }

    /** 
     * Exibe o Array que contabiliza os ganhos recebidos.
     * @return retorna o Array com os ganhos contabilizados.
     */
    public String exibeGanhos( ) {

        listaGanhos = "";

        for (int i = 0; i < tamanho; i++) {

            if (i == 0) {
                listaGanhos += (i + 1) + " - " + ganhos[i];
            } else {
                listaGanhos += "\n" + (i + 1) + " - " + ganhos[i];
            }

        }

        return listaGanhos;

    }

    /** 
     * Exibe as informalçoes para o usuario.
     * @return retorna Total recebidos, Despesas totais e Total Disponível.
     */
    public String toString( ) {

        total = 0;

        for (int i = 0; i < tamanho; i++) {

            total += ganhos[i];

        }

        total += inicial;
        retorno = "Total recebidos: " + total + ", Despesas totais: " + despesas + ", Total disponível: " + (total - despesas);

        return retorno;
    }

}