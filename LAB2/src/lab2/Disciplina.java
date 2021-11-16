package lab2;

/**
 * A classe Disciplina cria uma disciplina e pode informar valores como: Horas de estudo da disciplina, se o aluno foi aprovado e seu histórico de notas. Toda disciplina tem um valor padrão de 4 notas para calcular a média, esse valor pode ser mudado, bem como o peso de cada nota para se calcular uma média pnderada.
 * 
 * @author Igor Arthur Ferreira Ramos
 */
public class Disciplina {

    private String nome;

    private double media;
    private double[] notas;

    private int tamanho = 4;
    private int horasestudo = 0;
    private int[] peso;

    private boolean status = false;
    
    /**
     * Constrói uma nova disciplina.
     * @param name nome da disciplina.
     */
    public Disciplina(String name) {
        nome = name;
        notas = new double[4];
    }

    /**
     * Constrói uma nova disciplina e informa o número de notas da mesma.
     * @param name nome da disciplina.
     * @param numeroNotas número de notas da disciplina.
     */
    public Disciplina(String name, int numeroNotas) {
        nome = name;
        tamanho = numeroNotas;
        notas = new double[tamanho];
    }

    /**
     * Constrói uma nova Disciplina, informa o número de notas da mesma e o peso de cada nota.
     * @param name nome da disciplina.
     * @param numeroNotas número de notas da disciplina.
     * @param pesoNotas array de pesos de cada nota.
     */
    public Disciplina(String name, int numeroNotas, int[] pesoNotas) {
        nome = name;
        tamanho = numeroNotas;
        peso = pesoNotas;
        notas = new double[tamanho];
        peso = pesoNotas;
    }

    /**
     * Cadastra horas de estudo na disciplina.
     * @param horas quantidade de horas cadastradas.
     */
    public void cadastraHoras(int horas) {
        horasestudo += horas;
    }

    /**
     * Cadastra nota na disciplina.
     * @param nota Nota a ser cadastrada. Caso não seja cadastrada nenhuma nota, o valor da nota será 0.0.
     * @param valorNota Posição da nota (1 a 4).
     */
    public void cadastraNota(int nota, double valorNota) {
        notas[nota - 1] = valorNota;
        media = 0.0;

        for (int i = 0; i < tamanho; i++) {
            
            if (peso != null) {
                media += (notas[i] * peso[i]) / 10;
            } else {
                media += notas[i] / tamanho;
            }

            
        }
    }

    /**
     * Mostra se o aluno foi aprovado.
     * @return true para aprovado, false para reprovado.
     */
    public boolean aprovado() {
        
        if (media >= 7) {
            status = true;
        }
        return status;
    }

    private String ArraytoString(double[] array) {
        String arraySt = "";
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                arraySt += "[" + array[i];
            } else { 
                arraySt += ", " + array[i];
            } if (i == array.length - 1) {
                arraySt += "]";
            }
        }
        return arraySt;
    }

    /**
     * Retorna ao usuário informações sobre a disciplina.
     * @return Nome da disciplina, horas de estudo e notas.
     */
    public String toString() {
        
        return nome + " " + horasestudo + " " + media + " " + ArraytoString(notas);
    }

}