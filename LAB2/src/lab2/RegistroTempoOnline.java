package lab2;

/**
* A classe RegistroTempoOnline cria uma disciplina e registra o tempo que o aluno dedicou à mesma. É possível informar o tempo online esperado para cada disciplina, caso não informado, o valor 120 será tido como padrão. O valos de tempo esperado é o dobro da carga horária da disciplina.
* 
* @author Igor Arthur Ferreira Ramos
*/
public class RegistroTempoOnline {
    
    private String Disc;

    private int esperado = 120;
    private int online = 0;
    
    private boolean meta = false;

    /**
     * Registra apenas o nome da disciplina e toma o valor 120 como tempo online padrão esperado.
     * @param nomeDisciplina define o nome da disciplina.
     */
    public RegistroTempoOnline (String nomeDisciplina) {
        Disc = nomeDisciplina;
    }

    /**
     * Registra o nome da disciplina e o tempo online esperado.
     * @param nomeDisciplina define o nome da disciplina.
     * @param tempoOnlineEsperado define tempo online esperado.
     */
    public RegistroTempoOnline (String nomeDisciplina, int tempoOnlineEsperado) {
        Disc = nomeDisciplina;
        esperado = tempoOnlineEsperado;
    }

    /**
     * Adiciona tempo às horas online dedicadas à disciplina.
     * @param tempo Quantidade de tempo a ser adicionada.
     */
    public void adicionaTempoOnline(int tempo) {
        online += tempo;
    }

    /**
     * Retorna se o aluno já atingiu a meta de tempo online da disciplina.
     * @return true para meta atingida e false para meta não atingida.
     */
    public boolean atingiuMetaTempoOnline() {
        if (online >= esperado) {
            meta = true;
        }
        return meta;
    }

    /**
     * Retorna informações sobre a disciplina.
     * @return Nome da disciplina, tempo online dedicado e tempo online esperado.
     */
    public String toString() {
        return Disc + " " + online + "/" + esperado;
    }
}
